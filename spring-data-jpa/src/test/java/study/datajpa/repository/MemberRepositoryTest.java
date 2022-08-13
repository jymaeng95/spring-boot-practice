package study.datajpa.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.dto.MemberDto;
import study.datajpa.entity.Member;
import study.datajpa.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    TeamRepository teamRepository;
    @PersistenceContext
    EntityManager em;

    @Test
    public void testMember() {
        System.out.println("memberRepository = " + memberRepository.getClass());
        Member member = new Member("zayson");

        // Spring Data JPA
        Member savedMember = memberRepository.save(member);

        Member findMember = memberRepository.findById(savedMember.getId()).get();

        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    public void basicCRUD() {
        Member member1 = new Member("member1");
        Member member2 = new Member("member2");
        memberRepository.save(member1);
        memberRepository.save(member2);

        // 단건 조회 검증
        Member findMember1 = memberRepository.findById(member1.getId()).get();
        Member findMember2 = memberRepository.findById(member2.getId()).get();
        assertThat(findMember1).isEqualTo(member1);
        assertThat(findMember2).isEqualTo(member2);

        findMember1.setUsername("member!!!!"); // 더티 체킹(변경 감지)

        // 리스트 조회
        List<Member> findMembers = memberRepository.findAll();
        assertThat(findMembers.size()).isEqualTo(2);

        // 카운트
        long count = memberRepository.count();
        assertThat(count).isEqualTo(2);

        memberRepository.delete(member1);
        memberRepository.delete(member2);

        long afterCount = memberRepository.count();
        assertThat(afterCount).isEqualTo(0);
    }

    @Test
    public void findByUsernameAndAgeGreaterThan() {
        Member member1 = new Member("member", 20);
        Member member2 = new Member("member", 10);
        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> findMembers = memberRepository.findByUsernameAndAgeGreaterThan("member", 15);
        assertThat(findMembers.get(0).getUsername()).isEqualTo("member");
        assertThat(findMembers.get(0).getAge()).isEqualTo(20);
        assertThat(findMembers.size()).isEqualTo(1);

    }

    @Test
    public void testNamedQuery() {
        Member member1 = new Member("member", 20);
        Member member2 = new Member("member1", 10);
        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> result = memberRepository.findByUsername("member");
        Member findMember = result.get(0);
        assertThat(findMember).isEqualTo(member1);
    }

    @Test
    public void testQuery() {
        Member member1 = new Member("member", 20);
        Member member2 = new Member("member1", 10);
        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> result = memberRepository.findUser("member", 20);
        Member findMember = result.get(0);
        assertThat(findMember).isEqualTo(member1);
    }

    @Test
    public void findUsernameList() {
        Member member1 = new Member("member", 20);
        Member member2 = new Member("member1", 10);
        memberRepository.save(member1);
        memberRepository.save(member2);

        List<String> usernameList = memberRepository.findUsernameList();
        for (String usernmae : usernameList) {
            System.out.println("usernmae = " + usernmae);
        }
    }
    
    @Test
    public void findMemberDto() {
        Team team = new Team("teamA");
        teamRepository.save(team);
        
        Member member1 = new Member("member", 20);
        member1.setTeam(team);
        
        Member member2 = new Member("member1", 10);
        member2.setTeam(team);
        
        memberRepository.save(member1);
        memberRepository.save(member2);

        List<MemberDto> findMemberDtos = memberRepository.findMemberDto();
        for (MemberDto memberDto : findMemberDtos) {
            System.out.println("memberDto = " + memberDto);
        }
    }

    @Test
    public void findByNames() {
        Member member1 = new Member("member", 20);
        Member member2 = new Member("member1", 10);
        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> result = memberRepository.findByNames(Arrays.asList("member", "member1"));
        for (Member member : result) {
            System.out.println("member = " + member);
        }
    }

    @Test
    public void returnType() {
        Member member1 = new Member("member", 20);
        Member member2 = new Member("member1", 10);
        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> members = memberRepository.findListByUsername("member");
        Member member = memberRepository.findMemberByUsername("member");
        Optional<Member> findMember = memberRepository.findOptionalByUsername("member");
    }

    @Test
    public void paging() {
        memberRepository.save(new Member("member1", 10));
        memberRepository.save(new Member("member2", 10));
        memberRepository.save(new Member("member3", 10));
        memberRepository.save(new Member("member4", 10));
        memberRepository.save(new Member("member5", 10));

        // 0 페이지에서 3개 가져오기
        int age = 10;
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "username"));

        //when
        Page<Member> page = memberRepository.findByAge(age, pageRequest);
//        Slice<Member> page = memberRepository.findByAge(age, pageRequest);
        page.map(member -> new MemberDto(member.getId(), member.getUsername(), null));
        // then
        List<Member> content = page.getContent();
        long totalElements = page.getTotalElements();

        assertThat(content.size()).isEqualTo(3);    // 현재 페이지 데이터 개수
        assertThat(page.getTotalElements()).isEqualTo(5);   // totalCount
        assertThat(page.getNumber()).isEqualTo(0);  // 가져온 페이지 번호
        assertThat(page.getTotalPages()).isEqualTo(2);  // 전체 페이지 개수
        assertThat(page.isFirst()).isTrue();    // 첫번째 페이지인지?
        assertThat(page.hasNext()).isTrue();    // 다음 페이지가 있는지?
        assertThat(page.isLast()).isFalse();    // 마지막 페이지인지?
    }

    @Test
    public void bulkUpdate() {
        memberRepository.save(new Member("member1", 10));
        memberRepository.save(new Member("member2", 19));
        memberRepository.save(new Member("member3", 20));
        memberRepository.save(new Member("member4", 21));
        memberRepository.save(new Member("member5", 40));

        // when
        int resultCount = memberRepository.bulkAgePlus(20);

        // 영속성 컨텍스트에 반영안된 것을 반영하고 초기화한다.
//        em.flush();
//        em.clear();

        // 영속성 컨텍스트에는 40 , DB에는 41 -> 영속성 컨텍스트가 초기화 안되었으므로 40으로 출력됨
        List<Member> result = memberRepository.findByUsername("member5");
        Member member = result.get(0);
        System.out.println("member = " + member);



        // then
        assertThat(resultCount).isEqualTo(3);
    }

    @Test
    public void findMemberLazy() {
        // given ]
        // member 1 -> teamA
        // member2 -> teamB

        Team teamA = new Team("teamA");
        Team teamB = new Team("TeamB");
        teamRepository.save(teamA);
        teamRepository.save(teamB);

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 10, teamB);

        memberRepository.save(member1);
        memberRepository.save(member2);

        em.flush();
        em.clear();

        // when
        List<Member> members = memberRepository.findAll();
        for (Member member : members) {
            System.out.println("member = " + member);

            // N + 1 문제 발생
            System.out.println("member.getTeam().getClass() = " + member.getTeam().getClass()); // 프록시 객체로 가져옴
            System.out.println("member.getTeam().getName() = " + member.getTeam().getName());  // 실제 객체가져옴
        }
    }
}
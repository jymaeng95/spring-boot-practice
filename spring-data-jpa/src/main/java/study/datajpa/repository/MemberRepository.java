package study.datajpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.datajpa.dto.MemberDto;
import study.datajpa.entity.Member;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 도메인에 특화됨
    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

//    void findTop3();

    // JPQL에 :파라미터가 명확하게 전달된 경우 @Param을 반드시 이용한다.
    @Query(name = "Member.findByUsername")
    // 생략 가능
    List<Member> findByUsername(@Param("username") String username);

    @Query("select m from Member m where m.username = :username and m.age = :age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);

    // 실제 값으로 가져오기
    @Query("select m.username from Member m")
    List<String> findUsernameList();

    // DTO로 조회하기 (new 사용) -> 생성자 선언하는 것 처럼 사용
    @Query("select new study.datajpa.dto.MemberDto(m.id, m.username, t.name) from Member m join m.team t")
    List<MemberDto> findMemberDto();

    @Query("select m from Member m where m.username in :names")
    List<Member> findByNames(@Param("names") List<String> names);

    List<Member> findListByUsername(String username);   // 리스트

    Member findMemberByUsername(String username); // 단일

    Optional<Member> findOptionalByUsername(String username); // Optional

    // 페이징
    @Query(value = "select m from Member m left join m.team t", countQuery = "select count(m.username) from Member m")
    Page<Member> findByAge(int age, Pageable pageable);

    // 벌크연산
    @Modifying(clearAutomatically = true) // JPA의 executeUpdate를 호출한다.
    @Query("update Member m set m.age = m.age + 1 where m.age >= :age")
    int bulkAgePlus(@Param("age") int age);

    // 페치조인 (연관된 엔티티 바로가져옴)
    @Query("select m from Member m left join fetch m.team")
    List<Member> findMEmberFetchJoin();

    @Override
    @EntityGraph(attributePaths = {"team"})
    List<Member> findAll();

    @EntityGraph(attributePaths = {"team"})
    @Query("select m from Member m")
    List<Member> findMemberEntityGraph();

//    @EntityGraph(attributePaths = {"team"})
    @EntityGraph("Member.all")
    List<Member> findEntityGraphByUsername(@Param("username") String username);

}


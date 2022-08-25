package study.querydsl;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.querydsl.entity.Member;
import study.querydsl.entity.QMember;
import study.querydsl.entity.Team;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static study.querydsl.entity.QMember.*;

@SpringBootTest
@Transactional
public class QuerydslBasicTest {
    @Autowired
    EntityManager em;

    JPAQueryFactory queryFactory;    // Querydsl 사용하기 위해 JPAQueryFactory 선언 필요

    @BeforeEach
    public void beforeEach() {
         queryFactory = new JPAQueryFactory(em);

        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");

        em.persist(teamA);
        em.persist(teamB);

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);

        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);
    }

    @Test
    public void startJPQL() {
        // member1 조회
        String qlString = "select m from Member m where m.username = :username";  // JPQL의 경우 String이기 때문에 런타임시 에러 파악
        Member findMember = em.createQuery(qlString, Member.class)
                .setParameter("username", "member1")
                .getSingleResult();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    public void startQuerydsl() {
        // member1 조회
//        QMember m = new QMember("m");// 어떤 QMember인지 이름을 준다. 정적 메서드를 주로 사용
//        QMember member = QMember.member;  // static final로 사용된다

        // 컴파일 타임에 에러 파악 가능
        Member findMember = queryFactory
                .select(member)
                .from(member)
                .where(member.username.eq("member1"))  // 기본적으로 preparedStatement의 파라미터 바인딩 사용
                .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    public void search() {
        // where 절 체이닝을 통한 검색조건 추가 가능
        Member findMember = queryFactory
                .selectFrom(member)
                .where(member.username.eq("member1").and(member.age.eq(10)))
                .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    public void searchAndParam() {
        // where 절 And인 경우 파라미터 형식으로 넘기는 것이 가능(Predicate ... 문법)
        Member findMember = queryFactory
                .selectFrom(member)
                .where(
                        member.username.eq("member1"),
                        member.age.eq(10))
                .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    public void reseultFetch() {
        // 리스트 조회 (getReulstList와 비슷)
        List<Member> fetch = queryFactory
                .selectFrom(member)
                .fetch();

        // 단일 데이터 조회 getSingleResult()와 비슷
        Member fetchOne = queryFactory
                .selectFrom(QMember.member)
                .fetchOne();

        // 첫 한건 조회
        Member fetchFirst = queryFactory
                .selectFrom(QMember.member)
                .fetchFirst();  //.limit(1).fetchOne()

        // 페이징에서 사용
        QueryResults<Member> results = queryFactory
                .selectFrom(member)
                .fetchResults();
        long total1 = results.getTotal();
        List<Member> content = results.getResults();

        // 토탈 카운트 쿼리
        long total = queryFactory.selectFrom(member)
                .fetchCount();

    }
}

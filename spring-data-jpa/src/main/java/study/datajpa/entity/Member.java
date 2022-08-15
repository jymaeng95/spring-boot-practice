package study.datajpa.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA의 표준 스펙에서 Default 생성자가 있어야한다. AccessLevel을 Protected까지 열어놔야한다.
@ToString(of = {"id","username","age"})     // 연관관계까지 출력하는 경우 연관관계를 타고 들어가서 확인하기 때문에 무한루프가 발생할 수 있다.
@NamedQuery(
        name="Member.findByUsername",
        query="select m from Member m where m.username = :username"
)
@NamedEntityGraph(name = "MEmber.all", attributeNodes = @NamedAttributeNode("team"))
public class Member extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "team_id")
    private Team team;


    public Member(String username) {
        this.username = username;
    }

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        if(team != null) {
            changeTeam(team);
        }
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }

    // 연관관계 편읨 메서드
    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}

package study.datajpa.practice.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Builder
    public Person(Long id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }
}

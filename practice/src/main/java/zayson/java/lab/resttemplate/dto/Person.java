package zayson.java.lab.resttemplate.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class Person implements Serializable {
    private String name;
    private Integer age;
    private List<String> interest;

    @Builder
    public Person(String name, Integer age, List<String> interest) {
        this.name = name;
        this.age = age;
        this.interest = interest;
    }
}

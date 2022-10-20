package zayson.java.lab.optional.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import zayson.java.lab.exception.CustomNotFoundException;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class Person {
    @NotEmpty
    private String name;
    private int age;
    private Address address;

    public void throwException() {
        throw new CustomNotFoundException("예외를 발생시켰습니다");
    }
}

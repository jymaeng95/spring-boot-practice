package zayson.java.lab.optional;


import org.assertj.core.api.Assertions;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import zayson.java.lab.exception.CustomNotFoundException;
import zayson.java.lab.optional.model.Address;
import zayson.java.lab.optional.model.Person;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class OptionalTest {
    @NotNull
    private Person notNullPerson() {
        Address address = new Address("분당", "현대", "중앙공원로");
        return new Person("zayson", 28, address);
    }

    @BeforeEach
    void setUp() {
        call = false;
    }

    @Test
    @DisplayName("Optional.empty")
    void emtpy() {
        Optional<Person> empty = Optional.empty();

        assertThat(empty).isNotNull();
        assertThat(empty).isEmpty();
        assertThat(empty).isNotPresent();
    }

    @Test
    @DisplayName("Optional.of with not null")
    void of_with_not_null() {
        Person person = notNullPerson();

        Optional<Person> optionalPerson = Optional.of(person);

        assertThat(optionalPerson).isNotEmpty();
        assertThat(optionalPerson.get()).isInstanceOf(Person.class);
    }

    @Test
    @DisplayName("Optional.of with null")
    void of_with_null() {
        Person person = null;

        // .of는 null이 들어오는 경우 NPE를 발생시킨다!
        assertThrows(NullPointerException.class, () -> Optional.of(person));
    }

    @Test
    @DisplayName("Optioanl.ofNullable with not null")
    void ofNullable_with_not_null() {
        Person person = notNullPerson();

        Optional<Person> optionalPerson = Optional.ofNullable(person);

        assertThat(optionalPerson).isNotEmpty();
        assertThat(optionalPerson.get()).isInstanceOf(Person.class);
    }

    @Test
    @DisplayName("Optioanl.ofNullable with null")
    void ofNullable_with_null() {
        Person person = null;

        Optional<Person> optionalPerson = Optional.ofNullable(person);

        // ofNullable의 경우 null을 넣어주었지만 null이 아니고 empty 객체가 들어간다.
        assertThat(optionalPerson).isNotNull();
        assertThat(optionalPerson).isEqualTo(Optional.empty());
    }

    @Test
    @DisplayName("Optional.get")
    void get_without_null() {
        Address address = new Address("분당", "현대", "중앙공원로");
        Person person = new Person("zayson", 28, address);

        Optional<Person> optionalPerson = Optional.of(person);

        assertThat(optionalPerson.get().getName()).isEqualTo("zayson");
        assertThat(optionalPerson.get().getAddress()).isInstanceOf(Address.class);
    }

    @Test
    @DisplayName("Optional.get with null")
    void get_with_null() {
        Person person = null;

        Optional<Person> optionalPerson = Optional.ofNullable(person);

        // 원본 객체가 null이고 Optional로 감싼 경우를 조횧할 때 NoSuchElementException이 발생한다.
        assertThrows(NoSuchElementException.class, optionalPerson::get);
    }

    @Test
    @DisplayName("Optional.orElse")
    void orElse_without_null() {
        Person person = notNullPerson();

        Optional<Person> optionalPerson = Optional.ofNullable(person);

        //원본 객체가 존재하더라도 orElse를 호출하는가?
        Person getPerson = optionalPerson.orElse(callMethod());
        assertThat(getPerson.getName()).isEqualTo("zayson");
        assertThat(call).isTrue();
    }

    @Test
    @DisplayName("Optional.orElse with null")
    void orElse_with_null() {
        Person emptyPerson = null;
        Person person = Optional.ofNullable(emptyPerson).orElse(callMethod());

        assertThat(person.getName()).isEqualTo("maeng");
        assertThat(person.getAddress()).isNotNull();
    }

    @Test
    @DisplayName("Optional.orElseGet")
    void orElseGet_without_null() {
        Person person = notNullPerson();

        Optional<Person> optionalPerson = Optional.ofNullable(person);

        // 원본 객체가 존재하는 경우 orElseGet()을 호출하는가?
        Person getPerson = optionalPerson.orElseGet(this::callMethod);

        assertThat(getPerson.getName()).isEqualTo("zayson");
        assertThat(call).isFalse();
    }

    @Test
    @DisplayName("Optional.orElseGet with null")
    void orElseGet_with_null() {
        Person emptyPerson = null;
        Person person = Optional.ofNullable(emptyPerson).orElseGet(this::callMethod);

        assertThat(person.getName()).isEqualTo("maeng");
        assertThat(person.getAddress()).isNotNull();
    }

    @Test
    @DisplayName("Optional.orElseThrow")
    void orElseThrow() {
        Person person = null;
        Optional<Person> optionalPerson = Optional.ofNullable(person);

        // person의 thorwException 메서드를 실행하면 CustomException을 던진다
        assertThrows(CustomNotFoundException.class, () -> optionalPerson.orElseThrow(() -> new CustomNotFoundException("error msg")));
    }

    @Test
    @DisplayName("Optional.map")
    void map() {
        Person person = new Person("maeng", 30, new Address("seoul", "woosung", "street"));

        String city = Optional.ofNullable(person)
                .map(Person::getAddress)
                .map(Address::getCity)
                .orElseGet(() -> "bundang");

        assertThat(city).isEqualTo("seoul");
    }

    @Test
    @DisplayName("Optional.filter")
    void filter() {
        Person person = new Person("maeng", 30, new Address("seoul", "woosung", "street"));

        String name = Optional.ofNullable(person)
                .filter(p -> p.getAge() > 28)
                .map(Person::getName)
                .orElseGet(() -> "zayson");

        assertThat(name).isEqualTo("maeng");
        assertThat(
                Optional.ofNullable(person).filter(p -> p.getAge() > 30)
        ).isEqualTo(Optional.empty());   // 30살 초과인경우 filter -> false
    }

    @Test
    @DisplayName("Optional.isPresent")
    void ifPresent() {
        Person person = new Person("maeng", 30, new Address("seoul", "woosung", "street"));

        boolean present = Optional.ofNullable(person).isPresent();

        assertTrue(present);
    }

    @Test
    @DisplayName("Optional.ifPresentOrElse")
    void ifPResentOrElse() {
        // 존재하는 경우
        Person person = new Person("maeng", 30, new Address("seoul", "woosung", "street"));
        Optional.ofNullable(person)
                .ifPresentOrElse(
                        p -> assertThat(p.getName()).isEqualTo("maeng"),
                        () -> System.out.println("수행되지 않는 경우!")
                );

        person = null;
        Optional.ofNullable(person)
                .ifPresentOrElse(
                        p -> assertThat(p.getName()).isEqualTo("maeng"),
                        () -> System.out.println("=============로직이 수행된다 ===============")
                );
    }

    private static boolean call;

    private Person callMethod() {
        // 호출 되는 경우 true로 값을 바꾼다.
        call = true;
        return new Person("maeng", 30, new Address("seoul", "woosung", "street"));
    }

}

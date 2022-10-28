package study.datajpa.practice.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import study.datajpa.practice.entity.Person;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    @DisplayName("save 호출 시 동작하는 쿼리 개수 확인")
    @Rollback(false)
    void 쿼리_횟수_확인() {
        Person person1 = Person.builder().name("zayson").age(28).build();
        Person person2 = Person.builder().name("zayson").age(28).build();

        personRepository.save(person1);
        personRepository.save(person1);
        assertThrows(Exception.class, () -> personRepository.save(person2));
    }
}
package study.datajpa.practice.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.practice.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        Person person = Person.builder().name("zayson").age(28).build();
        personRepository.save(person);
    }

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

    @Test
    @DisplayName("동일 엔티티 반복 더티체킹 시 몇번의 쿼리가 발생할까?")
    @Rollback(false)
    void 동일_엔티티_수정_쿼리_횟수() {

        // when
        Person savedPerson = personRepository.findById(1L).orElseGet(() -> Person.builder().build());
        savedPerson.setAge(30);
        savedPerson.setAge(50);
    }
}
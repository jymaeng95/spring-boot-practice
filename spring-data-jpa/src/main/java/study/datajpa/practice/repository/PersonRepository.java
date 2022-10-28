package study.datajpa.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpa.practice.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}

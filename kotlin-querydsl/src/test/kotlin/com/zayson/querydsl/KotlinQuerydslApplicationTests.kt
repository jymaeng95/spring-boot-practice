package com.zayson.querydsl

import com.querydsl.jpa.impl.JPAQueryFactory
import com.zayson.querydsl.entity.Hello
import com.zayson.querydsl.entity.QHello
import jakarta.persistence.EntityManager
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class KotlinQuerydslApplicationTests (
    @Autowired val em: EntityManager
){

    @Test
    fun contextLoads() {
        val hello = Hello()
        em.persist(hello)

        val query = JPAQueryFactory(em)
        val qHello = QHello.hello
        val result = query
            .selectFrom(qHello)
            .fetchOne()

        Assertions.assertThat(result).isEqualTo(hello)
        Assertions.assertThat(result!!.id).isEqualTo(hello.id)
    }
}

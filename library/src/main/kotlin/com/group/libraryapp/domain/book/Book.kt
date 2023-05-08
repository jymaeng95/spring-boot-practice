package com.group.libraryapp.domain.book

import java.lang.IllegalArgumentException
import javax.persistence.*


@Entity
class Book (
    val name: String,

    @Enumerated(EnumType.STRING)
    val type: BookType, // 필수값

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
){
    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 비어 있을 수 없습니다.")
        }
    }

    companion object {
        /**
         * 테스트 코드를 위한 정적 팩토리 메서드
         * Book Entity에 컬럼이 추가되더라도, fixture에 default Parameter를 추가해 테스트 코드의 변경 없이 동작할 수 있도록 할 수 있다
         */
        fun fixture(name: String = "책 이름", type: BookType = BookType.COMPUTER, id: Long? = null) = Book(name, type, id)

    }
}
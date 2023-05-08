package com.group.libraryapp.service.book

import com.group.libraryapp.domain.book.Book
import com.group.libraryapp.domain.book.BookRepository
import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository
import com.group.libraryapp.dto.book.request.BookLoanRequest
import com.group.libraryapp.dto.book.request.BookRequest
import com.group.libraryapp.dto.book.request.BookReturnRequest
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BookServiceTest @Autowired constructor(
    private val bookService: BookService,
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository,
    private val userLoanHistoryRepository: UserLoanHistoryRepository,
) {
    @AfterEach
    fun clean() {
        bookRepository.deleteAll()
        userRepository.deleteAll()
    }

    @Test
    fun `책 저장 테스트`() {
        // given
        val request = BookRequest.fixture("코틀린 인 액션")

        // when
        bookService.saveBook(request)

        // then
        val books = bookRepository.findAll()
        assertThat(books).hasSize(1)
        assertThat(books[0].name).isEqualTo("코틀린 인 액션")
    }

    @Test
    fun `책 대여 성공 테스트 `() {
        // given
        bookRepository.save(Book.fixture("코틀린 인 액션"))
        val savedUser = userRepository.save(User("zayson", 29))
        val request = BookLoanRequest("zayson", "코틀린 인 액션")

        // when
        bookService.loanBook(request)

        // then
        val results = userLoanHistoryRepository.findAll()
        assertThat(results[0].bookName).isEqualTo("코틀린 인 액션")
        assertThat(results[0].user.id).isEqualTo(savedUser.id)
        assertThat(results[0].isReturn).isFalse()
    }

    @Test
    fun `책이 이미 대여된 경우 테스트가 실패한다`() {
        // given
        bookRepository.save(Book.fixture("코틀린 인 액션"))
        val savedUser = userRepository.save(User("zayson", 29))
        userLoanHistoryRepository.save(UserLoanHistory(savedUser, "코틀린 인 액션", false))
        val request = BookLoanRequest("zayson", "코틀린 인 액션")

        // when & then
        assertThrows<IllegalArgumentException> {
            bookService.loanBook(request)
        }.apply {
            assertThat(message).isEqualTo("진작 대출되어 있는 책입니다")
        }
    }

    @Test
    fun `책 반납 테스트`() {
        // given
        val savedUser = userRepository.save(User("zayson", 29))
        userLoanHistoryRepository.save(UserLoanHistory(savedUser, "코틀린 인 액션", false))
        val request = BookReturnRequest("zayson", "코틀린 인 액션")

        // when
        bookService.returnBook(request)

        // then
        val results = userLoanHistoryRepository.findAll()
        assertThat(results).hasSize(1)
        assertThat(results[0].isReturn).isTrue()
    }
}
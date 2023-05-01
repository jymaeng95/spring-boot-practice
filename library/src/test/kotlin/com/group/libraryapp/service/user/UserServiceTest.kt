package com.group.libraryapp.service.user

import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.dto.user.request.UserCreateRequest
import com.group.libraryapp.dto.user.request.UserUpdateRequest
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest @Autowired constructor (
    private val userRepository: UserRepository,
    private val userService: UserService,
){
    @AfterEach
    fun clean() {
        userRepository.deleteAll()  // SpringBootTest는 Spring Context를 공유하므로 정확한 테스트를 위해 매번 clean 해주자
    }

    @Test
    fun `회원 저장 테스트`() {
        // given
        val request = UserCreateRequest("zayson", null)

        // when
        userService.saveUser(request)

        // then
        val result = userRepository.findAll()
        assertThat(result).hasSize(1)  // size는 hasSize로 비교하자
        assertThat(result[0].name).isEqualTo("zayson")
        assertThat(result[0].age).isNull()  // user.getAge()가 플랫폼 타입 = Integer가 Null/NotNull 판단 불가
    }

    @Test
    fun `회원 목록 조회 테스트`() {
        // given
        userRepository.saveAll(
            listOf(
                User("zayson", 29),
                User("maeng", null),
            )
        )

        // when
        val results = userService.getUsers()

        // then
        assertThat(results).hasSize(2)
        assertThat(results).extracting("name").containsExactlyInAnyOrder("zayson","maeng")  // 프로퍼티 이름을 extracting하여 검증 가능
        assertThat(results).extracting("age").containsExactlyInAnyOrder(29, null)  // 프로퍼티 이름을 extracting하여 검증 가능
    }

    @Test
    fun `회원 수정 테스트`() {
        // given
        val savedUser = userRepository.save(
            User(
                "zayson",
                null
            )
        )
        val request = UserUpdateRequest(savedUser.id!!, "B")

        // when
        userService.updateUserName(request)

        // then
        val result = userRepository.findAll()[0]
        assertThat(result.name).isEqualTo("B")
    }

    @Test
    fun `회원 삭제 테스트`() {
        // given
        val savedUser = userRepository.save(
            User(
                "zayson",
                null
            )
        )

        // when
        userService.deleteUser("zayson")

        // then
        assertThat(userRepository.findAll()).isEmpty()
    }
}
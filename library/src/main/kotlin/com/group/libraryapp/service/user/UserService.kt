package com.group.libraryapp.service.user

import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.dto.user.request.UserCreateRequest
import com.group.libraryapp.dto.user.request.UserUpdateRequest
import com.group.libraryapp.dto.user.response.UserResponse
import com.group.libraryapp.util.fail
import com.group.libraryapp.util.findByIdOrThrow
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
) {
    /**
     * @Transactional을 사용하려면 메서드가 오버라이딩 가능해야함 (Transactional Proxy 기반 AOP를 통해 동작 -> Proxy를 위해 상속 및 오버라이딩을 통한 조작)
     * 상속 및 오버라이딩을 해주기 위해 open을 붙여줄 필요가 있음
     * open을 매번 붙여주기 어려우므로 플러그인으로 대체
     */
    @Transactional
    open fun saveUser(request: UserCreateRequest) {
        val newUser = User(request.name, request.age)
        userRepository.save(newUser)
    }

    @Transactional(readOnly = true)
    fun getUsers(): List<UserResponse> = userRepository.findAll()
        .map(UserResponse::of)

    @Transactional
    fun updateUserName(request: UserUpdateRequest) {
        // Crud Repository의 경우 Optional이지만 CurdRepositoryExtension 확장 함수 지원
//        val user = userRepository.findById(request.id).orElseThrow(::IllegalArgumentException)
        val user = userRepository.findByIdOrThrow(request.id)
        user.updateName(request.name)
    }

    @Transactional
    fun deleteUser(name: String) {
        val user = userRepository.findByName(name) ?: fail()
        userRepository.delete(user)
    }
}
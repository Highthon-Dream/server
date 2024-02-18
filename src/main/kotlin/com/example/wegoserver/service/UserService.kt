package com.example.wegoserver.service

import com.example.wegoserver.domain.UserEntity
import com.example.wegoserver.domain.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
) {
    @Transactional(readOnly = true)
    fun getUserDetail(userIdentify: String): UserEntity {
        return userRepository.findByIdentify(userIdentify) ?: throw RuntimeException("User Not Foun")
    }
}
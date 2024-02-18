package com.example.wegoserver.interfaces

import com.example.wegoserver.domain.UserEntity
import com.example.wegoserver.service.UserService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService,
) {
    @Operation(summary = "유저 상세 조회")
    @GetMapping("/users")
    fun getUserDetail(
        @RequestHeader("USER-IDENTIFY") userIdentify: String,
    ): UserEntity {
        return userService.getUserDetail(userIdentify)
    }
}
package com.example.wegoserver.interfaces

import com.example.wegoserver.domain.AnswerEntity
import com.example.wegoserver.domain.QuestionEntity
import com.example.wegoserver.interfaces.request.CreateAnswerRequest
import com.example.wegoserver.interfaces.request.CreateQuestionRequest
import com.example.wegoserver.service.QuestionService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class QuestionController(
    private val questionService: QuestionService,
) {
    @Operation(summary = "질문 작성")
    @PostMapping("/question")
    fun createQuestion(
        @RequestHeader("USER-IDENTIFY") userIdentify: String,
        @RequestBody request: CreateQuestionRequest,
    ): QuestionEntity {
        return questionService.createQuestion(userIdentify, request)
    }

    @Operation(summary = "답변 작성")
    @PostMapping("/question/{questionId}/answer")
    fun createAnswer(
        @RequestHeader("USER-IDENTIFY") userIdentify: String,
        @PathVariable("questionId") questionId: Long,
        @RequestBody request: CreateAnswerRequest,
    ): AnswerEntity {
        return questionService.createAnswer(userIdentify, questionId, request)
    }

    @Operation(summary = "질문 목록 조회")
    @GetMapping("/question")
    fun getQuestions(
        @RequestHeader("USER-IDENTIFY") userIdentify: String,
    ): List<QuestionEntity> {
        return questionService.getQuestions(userIdentify)
    }

    @Operation(summary = "질문 상세 조회")
    @GetMapping("/question/{questionId}")
    fun getQuestionDetail(
        @RequestHeader("USER-IDENTIFY") userIdentify: String,
        @PathVariable("questionId") questionId: Long,
    ): QuestionEntity {
        return questionService.getQuestionDetail(userIdentify, questionId)
    }

    @Operation(summary = "답변 목록 조회")
    @GetMapping("/question/{questionId}/answer")
    fun getAnswers(
        @RequestHeader("USER-IDENTIFY") userIdentify: String,
        @PathVariable("questionId") questionId: Long,
    ): List<AnswerEntity> {
        return questionService.getAnswers(userIdentify, questionId)
    }
}
package com.example.wegoserver.service

import com.example.wegoserver.domain.AnswerEntity
import com.example.wegoserver.domain.AnswerRepository
import com.example.wegoserver.domain.QuestionEntity
import com.example.wegoserver.domain.QuestionRepository
import com.example.wegoserver.domain.UserRepository
import com.example.wegoserver.interfaces.request.CreateAnswerRequest
import com.example.wegoserver.interfaces.request.CreateQuestionRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.ZonedDateTime

@Service
class QuestionService(
    private val userRepository: UserRepository,
    private val questionRepository: QuestionRepository,
    private val answerRepository: AnswerRepository,
) {
    @Transactional
    fun createQuestion(userIdentify: String, request: CreateQuestionRequest): QuestionEntity {
        val user = userRepository.findByIdentify(userIdentify) ?: throw RuntimeException("User Not Found")

        val question = QuestionEntity(
            title = request.title,
            content = request.content,
            user = user,
            createdAt = ZonedDateTime.now(),
        )

        return questionRepository.save(question)
    }

    @Transactional
    fun createAnswer(userIdentify: String, questionId: Long, request: CreateAnswerRequest): AnswerEntity {
        val user = userRepository.findByIdentify(userIdentify) ?: throw RuntimeException("User Not Found")
        val question = questionRepository.findByIdOrNull(questionId) ?: throw RuntimeException("Question Not Found")

        val answer = AnswerEntity(
            content = request.content,
            user = user,
            question = question,
            createdAt = ZonedDateTime.now(),
        )

        return answerRepository.save(answer)
    }

    @Transactional(readOnly = true)
    fun getQuestions(userIdentify: String): List<QuestionEntity> {
        return questionRepository.findAll()
    }

    @Transactional(readOnly = true)
    fun getQuestionDetail(userIdentify: String, questionId: Long): QuestionEntity {
        return questionRepository.findByIdOrNull(questionId) ?: throw RuntimeException("Question Not Found")
    }

    @Transactional(readOnly = true)
    fun getAnswers(userIdentify: String, questionId: Long): List<AnswerEntity> {
        return answerRepository.findAllByQuestionId(questionId)
    }
}

package com.example.wegoserver.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AnswerRepository : JpaRepository<AnswerEntity, Long> {
    fun findAllByQuestionId(questionId: Long): List<AnswerEntity>
}
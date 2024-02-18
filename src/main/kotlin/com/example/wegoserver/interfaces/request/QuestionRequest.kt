package com.example.wegoserver.interfaces.request

data class CreateQuestionRequest(
    val title: String,
    val content: String,
)

data class CreateAnswerRequest(
    val content: String,
)



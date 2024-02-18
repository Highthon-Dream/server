package com.example.wegoserver.interfaces.request

data class CreateBucketListRequest(
    val title: String,
    val content: String?,
)

data class EditBucketListRequest(
    val title: String,
    val content: String?,
)

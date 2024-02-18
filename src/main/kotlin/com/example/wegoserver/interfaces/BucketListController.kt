package com.example.wegoserver.interfaces

import com.example.wegoserver.domain.BucketListEntity
import com.example.wegoserver.interfaces.request.CreateBucketListRequest
import com.example.wegoserver.interfaces.request.EditBucketListRequest
import com.example.wegoserver.service.BucketListService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class BucketListController(
    private val bucketListService: BucketListService,
) {
    @Operation(summary = "버킷리스트 작성")
    @PostMapping("/bucket-list")
    fun createBucketList(
        @RequestHeader("USER-IDENTIFY") userIdentify: String,
        @RequestBody request: CreateBucketListRequest,
    ): BucketListEntity {
        return bucketListService.createBucketList(userIdentify, request)
    }

    @Operation(summary = "버킷리스트 수정")
    @PutMapping("/bucket-list/{bucketListId}")
    fun editBucketList(
        @RequestHeader("USER-IDENTIFY") userIdentify: String,
        @PathVariable("bucketListId") bucketListId: Long,
        @RequestBody request: EditBucketListRequest,
    ): BucketListEntity {
        return bucketListService.editBucketList(userIdentify, bucketListId, request)
    }

    @Operation(summary = "버킷리스트 목록 조회")
    @GetMapping("/bucket-list")
    fun getBucketLists(
        @RequestHeader("USER-IDENTIFY") userIdentify: String,
    ): List<BucketListEntity> {
        return bucketListService.getBucketLists()
    }

    @Operation(summary = "버킷리스트 상세 조회")
    @GetMapping("/bucket-list/{bucketListId}")
    fun getBucketListDetail(
        @RequestHeader("USER-IDENTIFY") userIdentify: String,
        @PathVariable("bucketListId") bucketListId: Long,
    ): BucketListEntity {
        return bucketListService.getBucketListDetail(bucketListId)
    }
}
package com.example.wegoserver.service

import com.example.wegoserver.domain.BucketListEntity
import com.example.wegoserver.domain.BucketListRepository
import com.example.wegoserver.domain.UserRepository
import com.example.wegoserver.interfaces.request.CreateBucketListRequest
import com.example.wegoserver.interfaces.request.EditBucketListRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.ZonedDateTime

@Service
class BucketListService(
    private val userRepository: UserRepository,
    private val bucketListRepository: BucketListRepository,
) {
    @Transactional
    fun createBucketList(userIdentify: String, request: CreateBucketListRequest): BucketListEntity {
        val user = userRepository.findByIdentify(userIdentify) ?: throw RuntimeException("User Not Found")

        val bucketList = BucketListEntity(
            title = request.title,
            content = request.content,
            user = user,
            createdAt = ZonedDateTime.now(),
        )

        return bucketListRepository.save(bucketList)
    }

    @Transactional
    fun editBucketList(userIdentify: String, bucketListId: Long, request: EditBucketListRequest): BucketListEntity {
        val bucketList = bucketListRepository.findByIdOrNull(bucketListId)
            ?: throw RuntimeException("BucketList Not Found")

        return bucketList.edit(request.title, request.content)
    }

    @Transactional(readOnly = true)
    fun getBucketLists(): List<BucketListEntity> {
        return bucketListRepository.findAll()
    }

    @Transactional(readOnly = true)
    fun getBucketListDetail(bucketListId: Long): BucketListEntity {
        return bucketListRepository.findByIdOrNull(bucketListId) ?: throw RuntimeException("BucketList Not Found")
    }
}

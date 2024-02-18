package com.example.wegoserver.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BucketListRepository : JpaRepository<BucketListEntity, Long> {
}
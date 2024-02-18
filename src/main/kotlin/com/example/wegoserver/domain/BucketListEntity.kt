package com.example.wegoserver.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.ZonedDateTime

@Entity
@Table(name = "BucketList")
class BucketListEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "title")
    var title: String,

    @Column(name = "content", columnDefinition = "LONGTEXT")
    var content: String?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: UserEntity,

    @Column(name = "created_at")
    val createdAt: ZonedDateTime,
) {
    fun edit(title: String, content: String?): BucketListEntity {
        this.title = title
        this.content = content

        return this
    }
}

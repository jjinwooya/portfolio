package com.jinwoo.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {
    @CreatedDate //시간자동생성
    @Column(nullable = false, updatable = false)
    var createdDateTime: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate //수정된 시간
    @Column(nullable = false)
    var updatedDateTime: LocalDateTime = LocalDateTime.now()
}
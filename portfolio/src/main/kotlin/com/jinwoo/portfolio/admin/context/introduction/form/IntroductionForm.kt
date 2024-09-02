package com.jinwoo.portfolio.admin.context.introduction.form

import com.jinwoo.portfolio.domain.entity.Introduction
import jakarta.validation.constraints.NotBlank

data class IntroductionForm(
    @field:NotBlank(message = "필수값")
    val content: String,
    val isActive: Boolean
) {

    fun toEntity(): Introduction {
        return Introduction(
            content = this.content,
            isActive = this.isActive
        )
    }

    fun toEntity(id: Long): Introduction {
        val introduction = toEntity()
        introduction.id = id
        return introduction
    }


}
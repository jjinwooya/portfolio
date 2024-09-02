package com.jinwoo.portfolio.admin.context.experience.form

import com.jinwoo.portfolio.domain.entity.ExperienceDetail
import jakarta.validation.constraints.NotBlank

class ExperienceDetailForm(
    val id: Long,
    @field:NotBlank(message = "필수값")
    val content: String,

    val isActive: Boolean
) {

    fun toEntity(): ExperienceDetail {
        return ExperienceDetail(
            content = this.content,
            isActive = this.isActive
        )
    }

}
package com.jinwoo.portfolio.admin.context.project.form

import com.jinwoo.portfolio.domain.entity.ProjectDetail
import jakarta.validation.constraints.NotBlank

class ProjectDetailForm(
    val id: Long,

    @field:NotBlank(message = "필수값")
    val content: String,

    val url: String?,

    val isActive: Boolean
) {
    fun toEntity(): ProjectDetail {
        return ProjectDetail(
            content = this.content,
            url = this.url,
            isActive = this.isActive
        )
    }
}
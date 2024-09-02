package com.jinwoo.portfolio.admin.context.project.form

import jakarta.validation.constraints.NotBlank

data class ProjectSkillForm(

    @field:NotBlank(message = "필수값")
    val project: String,

    @field:NotBlank(message = "필수값")
    val skill: String
)
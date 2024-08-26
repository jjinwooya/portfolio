package com.jinwoo.portfolio.domain.repository

import com.jinwoo.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project,Long>{

    fun findAllByIsActive(active: Boolean): List<Project>

    //override fun findById(id: Long): Optional<Project>
}
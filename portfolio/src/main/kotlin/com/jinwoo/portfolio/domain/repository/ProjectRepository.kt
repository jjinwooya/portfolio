package com.jinwoo.portfolio.domain.repository

import com.jinwoo.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project,Long>{


}
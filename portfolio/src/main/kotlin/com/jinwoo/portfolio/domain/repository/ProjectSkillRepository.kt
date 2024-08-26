package com.jinwoo.portfolio.domain.repository

import com.jinwoo.portfolio.domain.entity.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProjectSkillRepository : JpaRepository<ProjectSkill,Long>{

    fun findByProjectId(projectId:Long, skillId: Long): Optional<ProjectSkill>

}
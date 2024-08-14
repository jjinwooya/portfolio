package com.jinwoo.portfolio.domain.repository

import com.jinwoo.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository : JpaRepository<Skill,Long>{


}
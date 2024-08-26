package com.jinwoo.portfolio.domain.repository

import com.jinwoo.portfolio.domain.constant.SkillType
import com.jinwoo.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SkillRepository : JpaRepository<Skill,Long>{

    fun findAllByIsActive(isActive:Boolean): List<Skill>

    fun findByNameIgnoreCaseAndType(name : String, type: SkillType):
            Optional<Skill>

}
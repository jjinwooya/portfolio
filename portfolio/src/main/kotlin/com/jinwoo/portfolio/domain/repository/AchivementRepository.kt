package com.jinwoo.portfolio.domain.repository

import com.jinwoo.portfolio.domain.entity.Achivement
import org.springframework.data.jpa.repository.JpaRepository

interface AchivementRepository : JpaRepository<Achivement,Long>{
    fun findAllByIsActive(isActive:Boolean): List<Achivement>

}
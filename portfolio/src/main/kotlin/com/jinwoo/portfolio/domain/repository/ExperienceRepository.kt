package com.jinwoo.portfolio.domain.repository

import com.jinwoo.portfolio.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*

interface ExperienceRepository : JpaRepository<Experience, Long> {
    @Query("select e from Experience e LEFT JOIN FETCH e.details where e.isActive = :isActive ")
    fun findAllByIsActive(@Param("isActive") active: Boolean): List<Experience>

    @Query("select e from Experience e LEFT JOIN FETCH e.details where e.id = :id")
    override fun findById(id: Long): Optional<Experience>

}
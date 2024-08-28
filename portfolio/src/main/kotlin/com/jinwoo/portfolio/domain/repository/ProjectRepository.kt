package com.jinwoo.portfolio.domain.repository

import com.jinwoo.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface ProjectRepository : JpaRepository<Project,Long>{

    fun findAllByIsActive(active: Boolean): List<Project>

    //override fun findById(id: Long): Optional<Project>

    @Query("select p from Project p left join fetch p.skills s left join fetch s.skill where p.isActive = :isActive")
    fun findByIsActive(isActive: Boolean): List<Project>


    @Query("select p from Project p left join fetch p.details where p.id = :id")
    override fun findById(id: Long): Optional<Project>


}
package com.jinwoo.portfolio.domain.repository

import com.jinwoo.portfolio.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceRepository : JpaRepository<Experience,Long>{


}
package com.jinwoo.portfolio.admin.context.experience.service

import com.jinwoo.portfolio.admin.data.TableDTO
import com.jinwoo.portfolio.admin.exception.AdminBadRequestException
import com.jinwoo.portfolio.domain.entity.Experience
import com.jinwoo.portfolio.domain.entity.ExperienceDetail
import com.jinwoo.portfolio.domain.repository.ExperienceRepository
import org.springframework.stereotype.Service

@Service
class AdminExperienceService(
    private val experienceRepository: ExperienceRepository
) {
    fun getExperienceTable(): TableDTO {
        val classInfo = Experience::class
        val entities = experienceRepository.findAll()
        return TableDTO.from(classInfo, entities, "details")
    }

    fun getExperienceDetailTable(id: Long?): TableDTO {
        val classInfo = ExperienceDetail::class
        val entities = if (id != null) experienceRepository.findById(id)
            .orElseThrow { throw AdminBadRequestException("id ${id}에 해당하는 값이 없음") }
            .details else emptyList()
        return TableDTO.from(classInfo, entities)
    }
}
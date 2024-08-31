package com.jinwoo.portfolio.admin.context.project.service

import com.jinwoo.portfolio.admin.data.TableDTO
import com.jinwoo.portfolio.admin.exception.AdminBadRequestException
import com.jinwoo.portfolio.domain.entity.Project
import com.jinwoo.portfolio.domain.entity.ProjectDetail
import com.jinwoo.portfolio.domain.repository.ProjectRepository
import org.springframework.stereotype.Service

@Service
class AdminProjectService(
    private val projectRepository: ProjectRepository
) {
    fun getProjectTable(): TableDTO {
        val classInfo = Project::class
        val entities = projectRepository.findAll()
        return TableDTO.from(classInfo, entities, "details", "skills")
    }

    fun getProjectDetailTable(id: Long?): TableDTO {
        val classInfo = ProjectDetail::class
        val entities = if (id != null) projectRepository.findById(id)
            .orElseThrow { throw AdminBadRequestException("id ${id}에 해당하는 값이 없음") }
            .details else emptyList()
        return TableDTO.from(classInfo, entities)
    }

}
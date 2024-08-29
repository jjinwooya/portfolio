package com.jinwoo.portfolio.presentation.service

import com.jinwoo.portfolio.presentation.dto.IntroductionDTO
import com.jinwoo.portfolio.presentation.dto.LinkDTO
import com.jinwoo.portfolio.presentation.dto.ProjectDTO
import com.jinwoo.portfolio.presentation.dto.ResumeDTO
import com.jinwoo.portfolio.presentation.repository.PresentationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PresentationService(
    private val presentationRepository: PresentationRepository
) {

    @Transactional(readOnly = true)
    fun getIntroductions(): List<IntroductionDTO> {
        val introductions = presentationRepository.getActiveIntroductions()
        return introductions.map { IntroductionDTO(it) }
    }

    @Transactional(readOnly = true)
    fun getLinks(): List<LinkDTO> {
        val links = presentationRepository.getActiveLinks()
        return links.map { LinkDTO(it) }
    }

    @Transactional(readOnly = true)
    fun getResume(): ResumeDTO {
        val experiences = presentationRepository.getActiveExperience()
        val achievements = presentationRepository.getActiveAchievements()
        val skills = presentationRepository.getActiveSkills()

        return ResumeDTO(experiences = experiences, achievements = achievements, skills = skills)
    }

    @Transactional(readOnly = true)
    fun getProjects(): List<ProjectDTO> {
        val projects = presentationRepository.getActiveProjects()

        return projects.map { ProjectDTO(it) }
    }

}
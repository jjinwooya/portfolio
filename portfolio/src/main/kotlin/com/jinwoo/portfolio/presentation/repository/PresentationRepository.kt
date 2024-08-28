package com.jinwoo.portfolio.presentation.repository

import com.jinwoo.portfolio.domain.entity.*
import com.jinwoo.portfolio.domain.repository.*
import org.springframework.stereotype.Repository

@Repository
class PresentationRepository(
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectRepository: ProjectRepository,
    private val experienceRepository: ExperienceRepository
) {
    fun getActiveAchievements() : List<Achievement> {
        return  achievementRepository.findAllByIsActive(true)
    }

    fun getActiveExperience() : List<Experience> {
        return  experienceRepository.findAllByIsActive(true)
    }

    fun getActiveIntroductions() : List<Introduction> {
        return  introductionRepository.findAllByIsActive(true)
    }

    fun getActiveLinks() : List<Link> {
        return  linkRepository.findAllByIsActive(true)
    }

    fun getActiveProjects() : List<Project> {
        return  projectRepository.findAllByIsActive(true)
    }

    fun getActiveSkills() : List<Skill> {
        return  skillRepository.findAllByIsActive(true)
    }



}
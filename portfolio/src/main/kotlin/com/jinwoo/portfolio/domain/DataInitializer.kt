package com.jinwoo.portfolio.domain

import com.jinwoo.portfolio.domain.constant.SkillType
import com.jinwoo.portfolio.domain.entity.*
import com.jinwoo.portfolio.domain.repository.*
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@Profile(value = ["default"])
class DataInitializer(
    private val achievementRepository: AchievementRepository ,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectRepository: ProjectRepository,
    private val experienceRepository: ExperienceRepository

) {
    @PostConstruct
    fun initializeData() {
        println("스프링실행 테스트 데이터를 초기화")
        val achievements = mutableListOf<Achievement>(
            Achievement(
                title = "2024년 10월 전에",
                description = "개발자로 취업",
                host = "최진우",
                achievedDate = LocalDate.of(2024, 9, 10),
                isActive = true

            ),
            Achievement(
                title = "취업함",
                description = "개발자",
                host = "최진우",
                achievedDate = LocalDate.of(2024, 9, 10),
                isActive = true

            )
        )
        achievementRepository.saveAll(achievements)

        val introductions = mutableListOf<Introduction>(
            Introduction(content = "꾸준하게 성장하는 사람이고", isActive = true),
            Introduction(content = "감사하는 마음을 가진 사람이며", isActive = true),
            Introduction(content = "감사함을 베풀 줄 아는 사람입니다.", isActive = true)
        )

        introductionRepository.saveAll(introductions)

        val links = mutableListOf<Link>(
            Link(name = "github", content = "https://github.com/jjinwooya", isActive = true)
        )

        linkRepository.saveAll(links)

        val experience1 = Experience(
            title = "대학",
            description = "전공",
            startYear = 2024,
            startMonth = 9,
            endYear = 2024,
            endMonth = 12,
            isActive = true
        )
        experience1.addDetails(
            mutableListOf(
                ExperienceDetail(content = "평점", isActive = true),
                ExperienceDetail(content = "좀 쩌는 듯", isActive = true)
            )
        )

        val experience2 = Experience(
            title = "회사",
            description = "무직",
            startYear = 2024,
            startMonth = 9,
            endYear = 2024,
            endMonth = 12,
            isActive = true
        )
        experience2.addDetails(
            mutableListOf(
                ExperienceDetail(content = "냥냥펀치", isActive = true),
                ExperienceDetail(content = "핵펀치", isActive = true)
            )
        )
        experienceRepository.saveAll(mutableListOf(experience1, experience2))

        val java = Skill(name = "JAVA", type = SkillType.LANGUAGE.name, isActive = true)
        val kotlin = Skill(name = "Kotlin", type = SkillType.LANGUAGE.name, isActive = true)
        skillRepository.saveAll(mutableListOf(java, kotlin))

        val project1 = Project(
            name = "대학",
            description = "전공",
            startYear = 2024,
            startMonth = 9,
            endYear = 2024,
            endMonth = 12,
            isActive = true
        )
        project1.addDetails(
            mutableListOf(
                ProjectDetail(content = "평점", url = null, isActive = true),
                ProjectDetail(content = "쿠오오", url = null, isActive = true),
            )
        )
        project1.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project1, skill = java),
                ProjectSkill(project = project1, skill = kotlin)
            )
        )
        val project2 = Project(
            name = "새대학",
            description = "새전공",
            startYear = 2024,
            startMonth = 9,
            endYear = 2024,
            endMonth = 12,
            isActive = true
        )
        project1.addDetails(
            mutableListOf(
                ProjectDetail(content = "새평점", url = null, isActive = true),
                ProjectDetail(content = "새쿠오오", url = null, isActive = true),
                ProjectDetail(content = "네이버", url = "www.naver.com", isActive = true)
            )
        )
        project2.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project2, skill = java),
                ProjectSkill(project = project2, skill = kotlin),

                )
        )
        projectRepository.saveAll(mutableListOf(project1, project2))

    }

}
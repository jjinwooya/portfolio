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
    private val achievementRepository: AchievementRepository,
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
                title = "정보처리기사 필기",
                description = "필기합격",
                host = "산업인력공단",
                achievedDate = LocalDate.of(2024, 3, 14),
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
            title = "부산 아이티윌",
            description = "국비지원교육",
            startYear = 2024,
            startMonth = 1,
            endYear = 2024,
            endMonth = 7,
            isActive = true
        )
        experience1.addDetails(
            mutableListOf(
                ExperienceDetail(content = "백엔드 개발자 교육", isActive = true)
               // ExperienceDetail(content = "6개월 국비지원 교육", isActive = true)
            )
        )


        experienceRepository.saveAll(mutableListOf(experience1))

        val java = Skill(name = "Java", type = SkillType.LANGUAGE.name, isActive = true)
        val kotlin = Skill(name = "Kotlin", type = SkillType.LANGUAGE.name, isActive = true)
        val spring = Skill(name = "Spring", type = SkillType.FRAMEWORK.name, isActive = true)
        val mysql = Skill(name = "Mysql", type = SkillType.DATABASE.name, isActive = true)
        val oracle = Skill(name = "Oracle", type = SkillType.DATABASE.name, isActive = true)
        skillRepository.saveAll(mutableListOf(java, kotlin,spring,mysql,oracle))

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
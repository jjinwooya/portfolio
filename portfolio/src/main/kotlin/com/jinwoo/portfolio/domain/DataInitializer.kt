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
            name = "부기무비(팀 프로젝트)",
            description = "영화예매사이트",
            startYear = 2024,
            startMonth = 4,
            endYear = 2024,
            endMonth = 5,
            isActive = true
        )
        project1.addDetails(
            mutableListOf(
                ProjectDetail(content = "영화 페이지 및 스토어 페이지 담당", url = null, isActive = true),
                ProjectDetail(content = "id= jinwoo1234 pw= 123456a! ", url = null, isActive = true),
                ProjectDetail(content = "부기무비 바로가기", url = "http://c3d2401t2.itwillbs.com/boogimovie", isActive = true)
            )
        )
        project1.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project1, skill = mysql),
                ProjectSkill(project = project1, skill = java),
                ProjectSkill(project = project1, skill = spring)
                )
        )
        val project2 = Project(
            name = "클래스윌(팀 프로젝트)",
            description = "원데이 수업 클래스",
            startYear = 2024,
            startMonth = 5,
            endYear = 2024,
            endMonth = 7,
            isActive = true
        )
        project2.addDetails(
            mutableListOf(
                ProjectDetail(content = "마이페이지 담당", url = null, isActive = true),
                ProjectDetail(content = "id= jinwoo@naver.com pw= 12345a ", url = null, isActive = true),
                ProjectDetail(content = "클래스윌 바로가기", url = "http://c3d2401t2.itwillbs.com/class-will", isActive = true)
            )
        )
        project2.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project2, skill = mysql),
                ProjectSkill(project = project2, skill = java),
                ProjectSkill(project = project2, skill = spring)

                )
        )
        val project3 = Project(
            name = "간단한 책 대여 (리눅스 및 아마존 EC2사용)",
            description = "리눅스 환경에서 아마존 EC2를 이용한 배포 및 가비아 도메인을 사용한 연결 프로젝트",
            startYear = 2024,
            startMonth = 8,
            endYear = 2024,
            endMonth = 8,
            isActive = true
        )
        project3.addDetails(
            mutableListOf(
                ProjectDetail(content = "리눅스 환경에서 아마존 EC2를 이용하여 배포", url = null, isActive = true),
                ProjectDetail(content = "가비아를 바탕으로 도메인 연결", url = null, isActive = true),
                ProjectDetail(content = "큰 기능은 없고 개인공부삼아 해봤습니다.", url = null, isActive = true),
                ProjectDetail(content = "책대여 바로가기", url = "http://www.jinwoo.pro:8080", isActive = true)
            )
        )
        project3.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project3, skill = java),
                ProjectSkill(project = project3, skill = spring)
            )
        )
        projectRepository.saveAll(mutableListOf(project1, project2,project3))

    }

}
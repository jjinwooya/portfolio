package com.jinwoo.portfolio.admin.context.achievement.service

import com.jinwoo.portfolio.admin.data.TableDTO
import com.jinwoo.portfolio.domain.entity.Achievement
import com.jinwoo.portfolio.domain.repository.AchievementRepository
import org.springframework.stereotype.Service

@Service
class AdminAchievementService(
    private val achievementRepository: AchievementRepository
) {

    fun getAchievements(): TableDTO {
        val classInfo = Achievement::class
        val entities = achievementRepository.findAll()

        return TableDTO.from(classInfo, entities)

    }
}
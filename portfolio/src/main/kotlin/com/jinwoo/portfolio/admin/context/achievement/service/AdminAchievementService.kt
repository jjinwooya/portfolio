package com.jinwoo.portfolio.admin.context.achievement.service

import com.jinwoo.portfolio.admin.context.achievement.form.AchievementForm
import com.jinwoo.portfolio.admin.data.TableDTO
import com.jinwoo.portfolio.domain.entity.Achievement
import com.jinwoo.portfolio.domain.repository.AchievementRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminAchievementService(
    private val achievementRepository: AchievementRepository
) {

    fun getAchievements(): TableDTO {
        val classInfo = Achievement::class
        val entities = achievementRepository.findAll()

        return TableDTO.from(classInfo, entities)

    }

    @Transactional
    fun save(form: AchievementForm) {
        val achievement = form.toEntity()
        achievementRepository.save(achievement)
    }

    @Transactional
    fun update(id: Long, form: AchievementForm) {
        val achievement = form.toEntity(id)
        achievementRepository.save(achievement)
    }


}
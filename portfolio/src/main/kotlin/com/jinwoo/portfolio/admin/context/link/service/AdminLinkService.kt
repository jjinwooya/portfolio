package com.jinwoo.portfolio.admin.context.link.service

import com.jinwoo.portfolio.admin.data.TableDTO
import com.jinwoo.portfolio.domain.entity.Link
import com.jinwoo.portfolio.domain.repository.LinkRepository
import org.springframework.stereotype.Service

@Service
class AdminLinkService(
    private val linkRepository: LinkRepository
) {
    fun getLinkTable(): TableDTO {
        val classInfo = Link::class
        val entities = linkRepository.findAll()
        return TableDTO.from(classInfo, entities)
    }
}
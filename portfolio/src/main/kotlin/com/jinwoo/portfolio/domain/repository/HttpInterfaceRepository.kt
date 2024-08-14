package com.jinwoo.portfolio.domain.repository

import com.jinwoo.portfolio.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository

interface HttpInterfaceRepository : JpaRepository<HttpInterface,Long>{


}
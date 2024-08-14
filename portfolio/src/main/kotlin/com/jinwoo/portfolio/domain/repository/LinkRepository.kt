package com.jinwoo.portfolio.domain.repository

import com.jinwoo.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository : JpaRepository<Link,Long>{


}
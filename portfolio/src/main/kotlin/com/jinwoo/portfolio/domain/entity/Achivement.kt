package com.jinwoo.portfolio.domain.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Achivement(title:String,
    description: String,
    achivedDate: LocalDate?,
    host: String,
    isActive: Boolean
    ) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achivement_id")
    var id: Long? = null
    var title: String = title
    var description: String = description
    var achivedDate: LocalDate? = achivedDate
    var host: String = host
    var isActive: Boolean = isActive
}
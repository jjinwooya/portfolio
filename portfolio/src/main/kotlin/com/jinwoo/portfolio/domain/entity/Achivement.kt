package com.jinwoo.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Achivement : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achivement_id")
    var id: Long? = null
}
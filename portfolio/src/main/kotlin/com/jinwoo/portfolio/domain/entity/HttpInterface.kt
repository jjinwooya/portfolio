package com.jinwoo.portfolio.domain.entity

import jakarta.persistence.*
import jakarta.servlet.http.HttpServletRequest

@Entity
class HttpInterface(httpServletRequest: HttpServletRequest) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "http_interface_id")
    var id: Long? = null

    val cookies: String? = httpServletRequest.cookies
        ?.map { "${it.name}:${it.value}" } // 쿠키 이름과 값을 "name:value" 형식으로 변환
        ?.joinToString(", ")
    var referer: String? = httpServletRequest.getHeader("referer")

    var localAddr: String? = httpServletRequest.localAddr

    var remoteAddr: String? = httpServletRequest.remoteAddr

    var remoteHost: String? = httpServletRequest.remoteHost

    var requestUri: String? = httpServletRequest.requestURI

    var userAgent: String? = httpServletRequest.getHeader("user-agent")

    //var createdDatetime: LocalDateTime = LocalDateTime.now()
}
package com.jinwoo.portfolio.admin.data

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class ApiResponse<T>(status: HttpStatus) : ResponseEntity<T>(status) {
    companion object {
        fun successCreate(): ResponseEntity<Any> {
            return ok("데이터저장")
        }

        fun successUpdate(): ResponseEntity<Any> {
            return ok("데이터수정")
        }

        fun successDelete(): ResponseEntity<Any> {
            return ok("데이터삭제")
        }
    }
}
package com.example.parayo.domain.auth

//회원 가입에 필요한 파라미터로 데이터 클래스

data class SignupRequest (
        val email : String,
        val name: String,
        val password: String,
        val fcmToken : String
        )
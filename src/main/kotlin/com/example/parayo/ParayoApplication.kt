package com.example.parayo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication // 1

//자신이 스프링 설정 클래스임을 알려줌
//패키지 하위의 스프링 components를 재귀적으로 탐색하여 등록
open class ParayoApplication

fun main() {
    runApplication<ParayoApplication>()
}


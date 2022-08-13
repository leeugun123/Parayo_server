package com.example.parayo.common

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController

//exception 처리 class


@ControllerAdvice // 1
@RestController
class ParayoExceptionHandler {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(ParayoException::class) //2
    fun handleParayoException(e : ParayoException) : ApiResponse{
        logger.error("API error", e)
        return ApiResponse.error(e.message)
    }
    //parayoException을 캐치하여 exception의 message를 전파

    @ExceptionHandler(java.lang.Exception::class)
    fun handleException(e: Exception) : ApiResponse{
        logger.error("API error", e)
        return ApiResponse.error("알 수 없는 오류가 발생했습니다.")
    }//parayoException을 제외한 모든 예외를 캐치함 -> 알 수 없는 오류가 발생했습니다.


}
package com.example.parayo.controller

import com.example.parayo.common.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController // 1
//HTTP 호출의 응답으로 뷰를 rendering x , HTTP의 본문의 직접 텍스트로 이루어진 데이터를 사용함을 의미
class HelloApiController {

    @GetMapping("/api/v1/hello") //2
    fun hello() = ApiResponse.ok("world")

    //즉 HTTP로 /api/v1/hello를 호출 , 주소를 의미

}
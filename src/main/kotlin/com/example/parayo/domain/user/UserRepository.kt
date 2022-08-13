package com.example.parayo.domain.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User,Long> {

    fun findByEmail(email : String): User?
    //이메일로 검색했을때 한 명 or 0명의 유저만 존재하기 때문에 User?를 반환


}
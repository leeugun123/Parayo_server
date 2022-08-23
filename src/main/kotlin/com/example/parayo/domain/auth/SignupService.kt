package com.example.parayo.domain.auth

import com.example.parayo.common.ParayoException
import com.example.parayo.domain.user.User
import com.example.parayo.domain.user.UserRepository
import org.mindrot.jbcrypt.BCrypt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service //비즈니스 로직을 관리하는 클래스
class SignupService @Autowired //빈 클래스를 자동으로 주입함
constructor(
    private val userRepository: UserRepository
    //생성자의 데이터의 읽기/쓰기 등을 담당함
){

    fun signup(signupRequest: SignupRequest){

        validateRequest(signupRequest)
        checkDuplicates(signupRequest.email)
        registerUser(signupRequest)
    }


    private fun validateRequest(signupRequest: SignupRequest){

        validateEmail(signupRequest.email)//유효한 이메일인지 확인
        validateName(signupRequest.name)//유효한 이름인지 확인
        validatePassword(signupRequest.password)//유효한 패스워드인지 확인

    }


    private fun validateEmail(email : String){

        val isNotValidEmail = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"
            .toRegex(RegexOption.IGNORE_CASE)
            .matches(email)
            .not()

        if(isNotValidEmail){
            throw ParayoException("이메일 형식이 올바르지 않습니다")
        }
    }

    private fun validateName(name: String){
        if(name.trim().length !in 2..20)
            throw ParayoException("이름은 2자 이상 20자 이하여야 합니다.")
    }

    private fun validatePassword(password : String){
        if(password.trim().length !in 8..20)
            throw ParayoException("비밀번호는 공백을 제외하고 8자 이상 20자 이하여야 합니다.")
    }

    private fun checkDuplicates(email : String){
        userRepository.findByEmail(email)?.let {
            throw ParayoException("이미 사용 중인 이메일입니다.")
        }
    }

    private fun registerUser(signupRequest: SignupRequest) =
        with(signupRequest){

            val hashedPassword = BCrypt.hashpw(password,BCrypt.gensalt())
            //비밀번호를 해싱하여 저장
            val user = User(email,hashedPassword,name,fcmToken)
            userRepository.save(user)

        }




}
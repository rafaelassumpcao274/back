package com.unilith.Back.V1.Controller

import com.unilith.Back.V1.Service.AuthService
import com.unilith.Back.V1.Vo.V1.Security.AccountCredentialsVo
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Authentication Endpoint")
@RestController
@RequestMapping("/auth")
class AuthController {

    @Autowired
    lateinit var authService: AuthService

    fun signIn(@RequestBody data:AccountCredentialsVo?): ResponseEntity<*>{
        return if( data!!.userName.isNullOrBlank() || data.password.isNullOrBlank())
            ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request")
            else authService.signIn(data!!)

    }

}
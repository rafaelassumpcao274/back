package com.unilith.Back.V1.Service

import com.unilith.Back.V1.Repository.UserRepository
import com.unilith.Back.V1.Vo.V1.Security.AccountCredentialsVo
import com.unilith.Back.V1.Vo.V1.Security.TokenVo
import com.unilith.Back.V1.security.JwtTokenProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.logging.Level
import java.util.logging.Logger

@Service
class AuthService {


    private lateinit var authenticationManager: AuthenticationManager

    @Autowired
    private lateinit var tokenProvider: JwtTokenProvider

    @Autowired
    private lateinit var repository: UserRepository

    private val logger = Logger.getLogger(AuthService::class.java.name)

    fun signIn(data:AccountCredentialsVo): ResponseEntity<*>{
        logger.log(Level.INFO, "Trying log user ${data.userName}");
        return try {
            val username = data.userName
            val password = data.password
            authenticationManager.authenticate(UsernamePasswordAuthenticationToken(username,password))
            val user = repository.findByUsername(username)
            val tokenResponse: TokenVo = if( user != null){
                tokenProvider.createAccessToken(username!!,user.roles)
            }else{
                throw UsernameNotFoundException("UserName $username not found !")
            }
            ResponseEntity.ok(tokenResponse);
        }catch (e:AuthenticationException){
            throw BadCredentialsException("Invalid username or Password supplied!");
        }
    }


}
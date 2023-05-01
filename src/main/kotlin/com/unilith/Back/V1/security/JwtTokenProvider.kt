package com.unilith.Back.V1.security

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT
import com.unilith.Back.V1.Exceptions.InvalidJwtAuthException
import com.unilith.Back.V1.Vo.V1.Security.TokenVo
import jakarta.annotation.PostConstruct
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.*


@Service
class JwtTokenProvider {

    @Value("\${security.jwt.token.secret-key:secret}")
    private var secretKey = "secret"

    @Value("\${security.jwt.token.expire-length:3600000}")
    private var validityInMilliseconds:Long =3_600_000// 1H

    @Autowired
    private lateinit var userDetailsService: UserDetailsService

    private lateinit var algorithm: Algorithm


    @PostConstruct
    protected fun init(){

        secretKey = Base64.getEncoder().encodeToString(secretKey.toByteArray())
        algorithm =Algorithm.HMAC256(secretKey.toByteArray())

    }

    fun createAccessToken(username:String,roles:List<String?>):TokenVo{

        val now = Date()
        val validity = Date(now.time + validityInMilliseconds)
        val accessToken = getAccessToken(username,roles,now,validity)
        val refreshToken = getRefreshToken(username,roles,now)

        return TokenVo(
            userName = username,
            authenticated = true,
            accessToken = accessToken,
            refreshToken = refreshToken,
            created = now,
            expiration = validity
        )
    }

    private fun getRefreshToken(username: String, roles: List<String?>, now: Date): String? {
        val validityrefresToken = Date(now.time+ validityInMilliseconds * 3)
        return  JWT.create()
            .withClaim("roles",roles)
            .withExpiresAt(validityrefresToken)
            .withSubject(username)
            .sign(algorithm)
    }

    private fun getAccessToken(username: String, roles: List<String?>, now: Date, validity: Date): String? {
        val issuerURL: String = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString()
        return  JWT.create()
            .withClaim("roles",roles)
            .withIssuedAt(now)
            .withExpiresAt(validity)
            .withSubject(username)
            .withIssuer(issuerURL)
            .sign(algorithm)
    }


    fun getAuthentication(token:String):Authentication{
        val decodedJWT : DecodedJWT = decodedToken(token)
        val userDetails: UserDetails  = userDetailsService.loadUserByUsername(decodedJWT.subject)

        return UsernamePasswordAuthenticationToken(userDetails,"",userDetails.authorities)
    }

    private fun decodedToken(token: String): DecodedJWT {
        val algorithm = Algorithm.HMAC256(secretKey.toByteArray())
        val verify:JWTVerifier = JWT.require(algorithm).build()
        return verify.verify(token)
    }
    
    fun resolveToken(req: HttpServletRequest):String?{
        val bearerToken = req.getHeader("Authorization")
        return removeBearerToken(bearerToken)
    }

    fun validateToken(token:String):Boolean{
        val decodedJWT = decodedToken(token)
        try {
            if(decodedJWT.expiresAt.before(Date()))  return false

            return true
        }
        catch (e:Exception){
            throw InvalidJwtAuthException("Expired or JWT token !")

        }
    }

    fun removeBearerToken(token:String?):String?{
        var bearer = "Bearer "
        if(!token.isNullOrBlank() && token.startsWith(bearer)){
            return token.substring(bearer.length);
        }
        return null;
    }
}
package com.unilith.Back.V1.Service

import com.unilith.Back.V1.Entity.V1.User
import com.unilith.Back.V1.Exceptions.ResourceNotFoundException
import com.unilith.Back.V1.Mapper.DozerMapper
import com.unilith.Back.V1.Repository.UserRepository
import com.unilith.Back.V1.Util.AuditoriaUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.logging.Level
import java.util.logging.Logger


@Service
class UserService(@field:Autowired var repository: UserRepository) :UserDetailsService{


    @Autowired
    private lateinit var mapper: DozerMapper

    @Autowired
    private lateinit var auditoriaUtil: AuditoriaUtil

    private val logger = Logger.getLogger(UserService::class.java.name)


    fun findById(id: Long): User {
        logger.log(Level.INFO, "Find One ViaCores");

        val viasCores: User? = repository.findById(id).orElseThrow({ ResourceNotFoundException("Objeto não Encontrado") });

        return mapper.parseObject(viasCores, User::class.java);


    }

    override fun loadUserByUsername(username: String?): UserDetails {
        logger.log(Level.INFO, "Find One User by UserName $username");

        val user: User? = repository.findByUsername(username)


        return user ?: throw UsernameNotFoundException("Username $username not found");

    }


}
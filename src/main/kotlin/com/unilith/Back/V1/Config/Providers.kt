package com.unilith.Back.V1.Config

import com.unilith.Back.V1.Util.infra.ViaCepAdapter
import com.unilith.Back.V1.Util.port.ApiCepPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Providers {

    @Bean
    fun ApiCepPort ():ApiCepPort { return ViaCepAdapter()}
}
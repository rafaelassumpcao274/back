package com.unilith.Back.V1.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun customOpenApi():OpenAPI{
        return OpenAPI()
            .info(
                Info()
                    .title("Restful API With Kotlin 1.6.10 SPRING Boot 3.0.0")
                    .version("v1")
                    .description("SOME ")
                    .termsOfService("")
                    .license(
                        License().name("Apache 2.0")
                    )

            )
    }
}
package com.example.wegoserver.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun openAPI(): OpenAPI? {
        return OpenAPI()
            .info(
                Info()
                    .title("Weego 프로젝트 API")
                    .description("Weego Weego")
                    .version("1.0.0")
            )
    }
}
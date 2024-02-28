package com.ropaformal.ecommerceropaformal.web.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Swagger para documentar los metodos
 */

@Configuration
class SwaggerConfig {
  @Bean
  fun api(): OpenAPI {
    return OpenAPI().info(
      Info()
        .title("E-commerce de Ropa formal")
        .description("Esta es una api creada en KOTLIN")
    )
  }
}

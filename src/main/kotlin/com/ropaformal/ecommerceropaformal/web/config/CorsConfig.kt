package com.ropaformal.ecommerceropaformal.web.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource


/**
 * Este metodo permite configurar los cors de acceso para poder
 * establecer conecciones con el frontend
 */

@Configuration
class CorsConfig {


  /**
   * Bean significa que tiene que pasar por el core de spring
   */

  @Bean
  fun corsConfigurationSource(): CorsConfigurationSource {
    val corsConfiguration = CorsConfiguration()
    corsConfiguration.setAllowedOriginPatterns(
      listOf("http://localhost:4000", "https://formal-wear-ecommerce.vercel.app")
    ) //ruta a las cuales se concede acceso
    corsConfiguration.allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "PATCH") // metodos permitidos
    corsConfiguration.allowedHeaders = listOf("*", "Authorization") //acceso a los headers para tomar el token
    corsConfiguration.exposedHeaders = listOf("Authorization")
    corsConfiguration.allowCredentials = true
    val source = UrlBasedCorsConfigurationSource()
    source.registerCorsConfiguration("/**", corsConfiguration)
    return source
  }
}

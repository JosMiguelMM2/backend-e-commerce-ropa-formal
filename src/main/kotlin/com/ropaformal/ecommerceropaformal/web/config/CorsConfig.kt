package com.ropaformal.ecommerceropaformal.web.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
class CorsConfig {

  @Bean
  fun corsConfigurationSource(): CorsConfigurationSource {
    val corsConfiguration = CorsConfiguration()
    corsConfiguration.setAllowedOriginPatterns(listOf("http://localhost:4200"))
    corsConfiguration.allowedMethods = listOf("GET, POST, PUT, DELETE, PATCH")
    val source = UrlBasedCorsConfigurationSource()
    source.registerCorsConfiguration("/**", corsConfiguration)
    return source
  }
}

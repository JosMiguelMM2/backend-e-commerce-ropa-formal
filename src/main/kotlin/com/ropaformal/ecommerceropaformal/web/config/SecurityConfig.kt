package com.ropaformal.ecommerceropaformal.web.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import kotlin.jvm.Throws

@Configuration
class SecurityConfig {
  @Bean
  @Throws(Exception::class) //habilita la opcion de encontrar errores
  fun filterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
    httpSecurity
      .cors { }
      .authorizeHttpRequests { customizeRequests ->
        customizeRequests
          .requestMatchers(HttpMethod.GET, "/prueba/**").hasAnyRole("ADMIN")
          .anyRequest()
          .authenticated()

      }.csrf { it.disable() }
      .httpBasic{}
    return httpSecurity.build()
  }

  @Bean
  fun passwordEncoder(): PasswordEncoder {
    return BCryptPasswordEncoder()
  }
}

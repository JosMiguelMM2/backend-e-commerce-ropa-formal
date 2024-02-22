package com.ropaformal.ecommerceropaformal.web.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import kotlin.jvm.Throws

@Configuration
class SecurityConfig {

  @Autowired
  private lateinit var jwtFilter: JwtFilter

  @Bean
  @Throws(Exception::class) //habilita la opcion de encontrar errores
  fun filterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
    httpSecurity
      .csrf { it.disable() }
      .cors { }
      .sessionManagement { sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
      .authorizeHttpRequests { customizeRequests ->
        customizeRequests
          .requestMatchers("/login/**").permitAll()
          .requestMatchers(HttpMethod.GET, "/prueba/**").hasAnyRole("ADMIN")
          .anyRequest()
          .authenticated()

      }
      .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)
    return httpSecurity.build()
  }

  //generar la incriptacion de contraseñas
  @Bean
  fun passwordEncoder(): PasswordEncoder {
    return BCryptPasswordEncoder()
  }

  //verifica la autenticacion
  @Bean
  fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager {
    return authenticationConfiguration.authenticationManager
  }
}

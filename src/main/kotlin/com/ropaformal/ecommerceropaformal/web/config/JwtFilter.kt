package com.ropaformal.ecommerceropaformal.web.config

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtFilter : OncePerRequestFilter() {

  @Autowired
  private lateinit var jwtUtil: JwtUtil

  @Autowired
  private lateinit var userDetailsService: UserDetailsService

  override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {

    // Se debe validar el JWT

    // Pasos

    // 1-> Validar que sea un header Authorization valido o provenga de este
    val authHeader: String? = request.getHeader(HttpHeaders.AUTHORIZATION)
    if (authHeader.isNullOrEmpty() || !authHeader.startsWith("Bearer ")) {
      filterChain.doFilter(request, response)
      return
    }


    // 2-> Validar que sea autentico el JWT
    val jwt: String = authHeader.split(" ")[1].trim()
    if (!this.jwtUtil.isValido(jwt)) {
      println("No es valido")
      filterChain.doFilter(request, response)
      return
    }
    // 3 -> Cargar l usuario del servicio de UserDetailsService

    val userName = this.jwtUtil.getUsername(jwt)
    val user: User = this.userDetailsService.loadUserByUsername(userName) as User

    // 4-> Cargar el usuario en el contexto de seguridad

    val authenticationToken =
      UsernamePasswordAuthenticationToken(user.username, user.password, user.authorities)

    SecurityContextHolder.getContext().authentication = authenticationToken
    println("Este es el token $authenticationToken")
    filterChain.doFilter(request, response)

  }
}

package com.ropaformal.ecommerceropaformal.web.config


import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.JWT
import com.auth0.jwt.exceptions.JWTVerificationException
import org.springframework.stereotype.Component
import java.util.Date
import java.util.concurrent.TimeUnit


@Component
class JwtUtil {

  private val secret_key: String = "<1(/?-e0k%£lK(H23&v89KOp/a?4H!nQZ(,]3£z2h|<ExKZw"
  private val ALGORIHM: Algorithm = Algorithm.HMAC256(secret_key)

  /**
   *   funcion para crear el el token
   */

  fun crearAlgorithm(userName: String): String {
    return JWT.create()
      .withSubject(userName)
      .withIssuer("j75bmLwq/(Y]7DCnA|YEXD=-t76#)x^r5;sC3U4xC2<l0/wO2D")
      .withIssuedAt(Date())
      .withExpiresAt(
        Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(5))
      ).sign(ALGORIHM)
  }

  /**
   * Verifica que el token sea valido y devueve una respuesta
   */

  fun isValido(jwt: String): Boolean {
    try {
      JWT.require(ALGORIHM)
        .build()
        .verify(jwt)
      return true
    } catch (e: JWTVerificationException) {
      return false
    }
  }


  /**
   * Retorna el nombre del usuario
   */
  fun getUsername(jwt: String): String {
    return JWT.require(ALGORIHM)
      .build()
      .verify(jwt)
      .subject
  }
}

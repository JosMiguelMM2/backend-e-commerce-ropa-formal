package com.ropaformal.ecommerceropaformal.service.dto

import lombok.Data

/**
 * Clase de dominio para tomar los datos del login
 */

@Data
data class LoginDto(
  val username: String,
  val password: String
) {
}

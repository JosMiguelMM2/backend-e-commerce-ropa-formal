package com.ropaformal.ecommerceropaformal.service.dto

import lombok.Data

@Data
data class LoginDto(
  val username: String,
  val password: String
) {
}

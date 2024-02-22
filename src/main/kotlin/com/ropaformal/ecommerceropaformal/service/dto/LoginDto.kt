package com.ropaformal.ecommerceropaformal.service

import lombok.Data

@Data
data class LoginDto(
  val username: String,
  val password: String
) {
}

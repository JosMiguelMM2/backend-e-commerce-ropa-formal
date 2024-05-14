package com.ropaformal.ecommerceropaformal.service.dto

import com.ropaformal.ecommerceropaformal.domain.clases.User
import com.ropaformal.ecommerceropaformal.persistence.entity.PersonaEntity

/**
 * Se crea esta clase para agrupar los dos servicios e inssertartar los dos componetes
 * a  la vez
 */
data class UserPersonasDTO(
  val user: User,
  val personas: PersonaEntity
) {}

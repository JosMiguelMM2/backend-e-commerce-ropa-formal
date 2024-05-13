package com.ropaformal.ecommerceropaformal.service.dto

data class PersonasDTO(

  val idPersonas: Int?,
  val nombre: String?,
  val apellido: String?,
  val numeroDocumento: String,
  val correo: String?,
  val telefono: String?,
  val tipoDocumentos: Int?
) {
}

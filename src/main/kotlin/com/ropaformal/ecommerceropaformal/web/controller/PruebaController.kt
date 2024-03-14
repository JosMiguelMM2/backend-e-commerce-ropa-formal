package com.ropaformal.ecommerceropaformal.web.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Desde aca se hacen pruebas de acceso
 */
@RestController
@RequestMapping("/e/api/prueba")
class PruebaController {

  @GetMapping
  fun getMensaje(): ResponseEntity<String> {
    val mensaje = mapOf("mensaje" to "Esto es una de prueba de acceso")
    val objeto = ObjectMapper()
    val json = objeto.writeValueAsString(mensaje)
    return ResponseEntity(json, HttpStatus.OK)
  }
}

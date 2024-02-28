package com.ropaformal.ecommerceropaformal.web.controller

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
  fun getMensaje(): String {
    return "Hola, soy una prueba de acceso"
  }
}

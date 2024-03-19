package com.ropaformal.ecommerceropaformal.web.controller

import com.ropaformal.ecommerceropaformal.persistence.entity.Prueba
import com.ropaformal.ecommerceropaformal.service.PruebaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tecnica")
class TecnicaController {
  @Autowired
  private lateinit var pruebaService: PruebaService

  @GetMapping()
  fun todo():ResponseEntity<Iterable<Prueba>>{
    return ResponseEntity.ok(this.pruebaService.getPruebaRepository())
  }

  @PostMapping()
  fun nuevo(@RequestBody prueba:Prueba):ResponseEntity<Prueba>{
    return ResponseEntity.ok(this.pruebaService.save(prueba))

  }
}

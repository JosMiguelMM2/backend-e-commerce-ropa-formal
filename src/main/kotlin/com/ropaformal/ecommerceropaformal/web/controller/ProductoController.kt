package com.ropaformal.ecommerceropaformal.web.controller

import com.ropaformal.ecommerceropaformal.persistence.entity.ProductoEntity
import com.ropaformal.ecommerceropaformal.service.ProductoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/e/producto")
class ProductoController {

  @Autowired
  private lateinit var productoService: ProductoService

  @GetMapping("/list")
  fun getAllProductos(): ResponseEntity<Set<ProductoEntity>> {
    return ResponseEntity.ok(this.productoService.getAllProductos())
  }
}

package com.ropaformal.ecommerceropaformal.web.controller

import com.ropaformal.ecommerceropaformal.persistence.entity.CarroCompraEntity
import com.ropaformal.ecommerceropaformal.service.CarCompService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/e/carcomp")
class CarCompController {

  @Autowired
  private lateinit var carCompService: CarCompService

  @GetMapping
  //@PreAuthorize("isAuthenticated()")
  fun getAll(): ResponseEntity<List<CarroCompraEntity>> {
    return ResponseEntity.ok(this.carCompService.getAll())
  }
}

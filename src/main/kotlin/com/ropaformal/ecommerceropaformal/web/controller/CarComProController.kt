package com.ropaformal.ecommerceropaformal.web.controller

import com.ropaformal.ecommerceropaformal.persistence.entity.CarroCompProduEntity
import com.ropaformal.ecommerceropaformal.service.CarComProService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/e/carcompropro")
class CarComProController {
  @Autowired
  private lateinit var carComProService: CarComProService

  @GetMapping("/list")
  fun getAll(): ResponseEntity<List<CarroCompProduEntity>> {
    return ResponseEntity.ok(this.carComProService.getAll())
  }
}

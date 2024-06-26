package com.ropaformal.ecommerceropaformal.persistence.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(name = "carro_compras__productos")
data class CarroCompProduEntity(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  val idCarrosComprasProductos: Int?,

  @Column(name = "cantidad", nullable = false)
  val cantidad:Int?,


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_producto")
  val productosEntity: ProductoEntity?,

  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_carro_compra")
  val carroCompras: CarroCompraEntity?
)

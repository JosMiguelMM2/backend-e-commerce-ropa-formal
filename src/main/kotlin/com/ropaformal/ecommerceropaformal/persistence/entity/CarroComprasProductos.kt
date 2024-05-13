package com.ropaformal.ecommerceropaformal.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "carro_compras__productos")
data class CarroComprasProductos(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  val idCarrosComprasProductos: Int?,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_producto")
  val productosEntity: ProductosEntity?,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_carro_compra")
  val carroCompras: CarroCompras?
)

package com.ropaformal.ecommerceropaformal.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Entity
@Table(name = "productos_pedidos")
@Getter
@Setter
@NoArgsConstructor
data class PedidosProductosEntity(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  val idProductosPedidos: Int?,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_producto")
  val productosEntity: ProductosEntity?,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_pedido")
  val pedidosEntity: PedidosEntity?
)

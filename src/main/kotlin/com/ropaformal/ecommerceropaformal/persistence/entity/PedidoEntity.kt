package com.ropaformal.ecommerceropaformal.persistence.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "pedidos")
@Setter
@Getter
@NoArgsConstructor
data class PedidoEntity(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  val idPedidos: Int?,

  @Column(name = "total_compra", precision = 19, scale = 2)
  val totalCompra: BigDecimal?,

  @Column(name = "fecha_pedido")
  val fechaPedido: LocalDateTime?,

  @Column(name = "direccion", length = 30, nullable = false)
  val direccion:String?,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_estado_pedido", nullable = false)
  val estadoPedidosEntity: EstadoPedidoEntity?,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_user")
  val userEntity: UserEntity?
) {}

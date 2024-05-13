package com.ropaformal.ecommerceropaformal.persistence.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Entity
@Table(name = "estado_pedidos")
@Getter
@Setter
@NoArgsConstructor
data class EstadoPedidoEntity(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  val idEstadoPedido: Int?,

  @Column(name = "estado", length = 30)
  val estado: String?,

  @OneToMany(mappedBy = "estadoPedidosEntity", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
  val pedidos: Set<PedidosEntity>?
) {}

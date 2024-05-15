package com.ropaformal.ecommerceropaformal.persistence.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(name = "carro_compras")
data class CarroCompraEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  val idCarroCompras:Int?,

  @Enumerated(EnumType.ORDINAL)
  @Column(name = "estado")
  val estado: EstadoCarro?,

  @JsonBackReference
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_user")
  val userEntity: UserEntity?,
)

enum class EstadoCarro {
  SIN_PAGAR,
  PAGADO
}

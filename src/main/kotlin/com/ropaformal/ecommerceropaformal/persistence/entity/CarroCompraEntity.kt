package com.ropaformal.ecommerceropaformal.persistence.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Entity
@Table(name = "carro_compras")
@Getter
@Setter
@NoArgsConstructor
data class CarroCompraEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  val idCarroCompras:Int?,

  @Enumerated(EnumType.ORDINAL)
  @Column(name = "estado")
  val estado: EstadoCarro?,

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_user")
  val userEntity: UserEntity?
)

enum class EstadoCarro {
  SIN_PAGAR,
  PAGADO
}

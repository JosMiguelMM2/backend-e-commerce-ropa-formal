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
data class CarroCompras(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  val idCarroCompras:Int?,

  @Column(name = "cantidas", nullable = false)
  val cantidad:Int?,

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_user")
  val userEntity: UserEntity?
)

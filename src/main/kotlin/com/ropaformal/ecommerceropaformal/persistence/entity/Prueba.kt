package com.ropaformal.ecommerceropaformal.persistence.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Entity
@Table(name = "prueba")
@Getter
@Setter
@NoArgsConstructor
data class Prueba (
  @Id
  //autonumerico
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column( nullable = false)
  val id: Int?,

  @Column(nullable = false, length = 70)
  val name: String?,

  @Column(nullable = false, length = 60)
  val activo: Boolean?,

  @Column(nullable = false, length = 200)
  var usado: Boolean?
){
}

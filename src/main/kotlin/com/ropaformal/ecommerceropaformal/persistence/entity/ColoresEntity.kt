package com.ropaformal.ecommerceropaformal.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Entity
@Table(name = "colores")
@Getter
@Setter
@NoArgsConstructor
data class ColoresEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  val idColores: Int?,

  @Column(name = "color", length = 40)
  val color: String?
) {}

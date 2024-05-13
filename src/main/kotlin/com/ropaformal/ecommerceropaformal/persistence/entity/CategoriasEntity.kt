package com.ropaformal.ecommerceropaformal.persistence.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Entity
@Table(name = "categorias")
@Setter
@Getter
@NoArgsConstructor
data class CategoriasEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  val idCategorias: Int?,

  @Column(name = "categoria", nullable = false)
  val categoria: String?
)

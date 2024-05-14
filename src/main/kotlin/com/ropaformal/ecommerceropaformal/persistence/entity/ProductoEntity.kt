package com.ropaformal.ecommerceropaformal.persistence.entity

import jakarta.persistence.*
import java.math.BigDecimal

enum class GeneroRopa{
  HOMBRE,
  MUJER
}

@Entity
@Table(name = "productos")
data class ProductoEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  val idProductos: Int?,

  @Column(name = "nombre")
  val nombre: String?,

  @Column(name = "descripcion")
  val descripcion: String?,

  @Enumerated(EnumType.ORDINAL)
  @Column(name = "genero")
  val genero:GeneroRopa?,

  @Column(name = "precio", precision = 19, scale = 2)
  val precio: BigDecimal?,

  @Column(name = "tamaño", length = 10)
  val size: String?,

  @Column(name = "url_imagen")
  val urlImagen: String?,

  @Column(name = "stock", nullable = false)
  val stock: Int?,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_color")
  val coloresEntity: ColorEntity?,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_categoria")
  val categoriasEntity: CategoriaEntity?
)


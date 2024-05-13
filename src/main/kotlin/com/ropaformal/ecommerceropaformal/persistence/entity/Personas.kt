package com.ropaformal.ecommerceropaformal.persistence.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Entity
@Table(name = "Personas")
@Getter
@Setter
@NoArgsConstructor
data class Personas(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  val idPersonas: Int?,

  @Column(length = 50)
  val nombre: String?,

  @Column(length = 50)
  val apellido: String?,

  @Column(name = "ndocumento")
  val numeroDocumento: Int?,

  @Column(length = 50)
  val correo: String?,

  @Column(name = "telefono")
  val telefono: Int?,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_tipo_documento", nullable = false)
  val tipoDocumentos: TipoDocumentos?,

  @JsonIgnore
  @OneToOne(mappedBy = "personas", cascade = [CascadeType.ALL])
  val userEntity: UserEntity?

) {}

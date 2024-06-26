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
data class PersonaEntity(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  val idPersonas: Int?,

  @Column(length = 50)
  val nombre: String?,

  @Column(length = 50)
  val apellido: String?,

  @Column(name = "ndocumento", length = 20)
  val numeroDocumento: String,

  @Column(length = 50)
  val correo: String?,

  @Column(name = "telefono", length = 10)
  val telefono: String?,

  @Column(name = "tipodocumento", length = 2)
  @Enumerated(EnumType.ORDINAL)
  val tipoDocumento: TipoDocumentoEntity,

  @JsonIgnore
  @OneToOne(mappedBy = "personas", cascade = [CascadeType.ALL])
  val userEntity: UserEntity?

)

enum class TipoDocumentoEntity {
  CC,
  CE,
  TI
}

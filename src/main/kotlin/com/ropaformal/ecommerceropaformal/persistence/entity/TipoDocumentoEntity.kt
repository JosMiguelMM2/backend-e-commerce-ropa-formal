package com.ropaformal.ecommerceropaformal.persistence.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Entity
@Table(name = "tipodocumentos")
@Getter
@Setter
@NoArgsConstructor
data class TipoDocumentoEntity(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(
    name = "id",
    nullable = false
  )
  val idTiposDocumentos: Int?,

  @Column(name = "documento", length = 20)
  val documento: String?,

  @JsonIgnore
  @OneToMany(mappedBy = "tipoDocumentos", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
  val personas: Set<PersonaEntity>?
) {}

package com.ropaformal.ecommerceropaformal.persistence.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.time.LocalDateTime


/**
 * La clase Mapea, crea o actualiza la entidad user_role
 * cada parametro es un tipo de dato de la tabla para la base de datos postgresQL
 */

@Entity
@Table(name = "user_role")

// Getters desde lombok
@Getter

//Setters desde lombok
@Setter

// Constructor de la clase sin parametros
@NoArgsConstructor
data class UserRoleEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, name = "idUserRole")
  val idUserRole: Int?,

  @Column(nullable = false, length = 20)
  val role: String?,

  @Column(name = "granted_date", nullable = false, columnDefinition = "TIMESTAMP")
  val granteDate: LocalDateTime?,

  @ManyToOne
  @JoinColumn(name = "username", insertable = true)
  val user: UserEntity?
) {
  override fun toString(): String {
    return "UserRolesEntity"
  }
}

package com.ropaformal.ecommerceropaformal.persistence.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.time.LocalDateTime

@Entity
@Table(name = "user_role")
@Getter
@Setter
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
  @JoinColumn(name = "username", insertable = false)
  val user: UserEntity?
) {
  override fun toString(): String {
    return "UserRolesEntity"
  }
}

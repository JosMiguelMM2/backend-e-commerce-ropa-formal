package com.ropaformal.ecommerceropaformal.persistence.entity

import com.ropaformal.ecommerceropaformal.domain.clases.User
import jakarta.persistence.*
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
data class UserEntity(
  @Id
  @Column(name = "username", nullable = false, length = 60)
  val username: String?,

  @Column(nullable = false, length = 40)
  val email: String?,

  @Column(nullable = false, length = 60)
  val name:String?,

  @Column(nullable = false, length = 200)
  var password: String?,

  @Column(nullable = false)
  var locked: Boolean = false,

  @Column(nullable = false)
  var disabled: Boolean = false,

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  val roles: List<UserRoleEntity>

) {
  override fun toString(): String {
    return "UserEntity"
  }

  fun toUser(): User {
    return User(
      username = this.username,
      name = this.name,
      password = this.password,
      email = this.email
    )
  }
}


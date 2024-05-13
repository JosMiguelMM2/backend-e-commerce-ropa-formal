package com.ropaformal.ecommerceropaformal.persistence.entity

import com.ropaformal.ecommerceropaformal.domain.clases.User
import jakarta.persistence.*
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter


/**
 * Se mapea la tabla para la base de datos,
 * la tabla es user, cada valor es un parametro diferente
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
data class UserEntity(
  @Id
  @Column(name = "username", nullable = false, length = 60)
  val username: String?,

  @Column(nullable = false, length = 200)
  var password: String?,

  @Column(nullable = false)
  var locked: Boolean = false,

  @Column(nullable = false)
  var disabled: Boolean = false,

  /**
   * Es aca donde se realiza la coneccion relacion de uno a muchos
   * a la tabala user_role
   */
  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  val roles: List<UserRoleEntity>,

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_persona", nullable = false)
  val personas: Personas
) {

  /**
   * Este es un metodo definido para el patron de diseño orientado al dominio
   * convierte de clase UserEntity a User
   */
  /*fun toUser(): User {
    return User(
      username = this.username,
      name = this.name,
      password = this.password,
      email = this.email,
    )
  }*/
}


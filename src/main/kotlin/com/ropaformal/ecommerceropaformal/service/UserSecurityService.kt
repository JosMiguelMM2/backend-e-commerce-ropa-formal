package com.ropaformal.ecommerceropaformal.service

import com.ropaformal.ecommerceropaformal.persistence.entity.UserEntity
import com.ropaformal.ecommerceropaformal.persistence.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserSecurityService : UserDetailsService {
  @Autowired
  private lateinit var userRepository: UserRepository
  override fun loadUserByUsername(username: String): UserDetails {
    val userEntity: Optional<UserEntity> = this.userRepository.findById(username)
    //val roles: Array<String> = userEntity.get().roles.map { it.role ?: "" }.toTypedArray()
    val rolesAsString: String = userEntity.get().roles.joinToString { it.role ?: "" }
    return User.builder()
      .username(userEntity.get().username)
      .password(userEntity.get().password)
      //.authorities(this.grantedAuthorities(roles))
      .roles(rolesAsString)
      .accountLocked(userEntity.get().locked)
      .disabled(userEntity.get().disabled)
      .build()
  }
  /*
    private fun getAuthorities(role: String): Array<String> {
      return if ("ADMIN".equals(role) || "CUSTOMER".equals(role)) {
        arrayOf<String>("random_order")
      } else {
        arrayOf<String>()
      }

    }

    private fun grantedAuthorities(roles: Array<String>): List<GrantedAuthority> {
      val authorities: List<GrantedAuthority> = ArrayList<GrantedAuthority>(roles.size)

      for (role in roles) {
        authorities.addLast(SimpleGrantedAuthority("ROLE_$role"))

        for (authority in this.getAuthorities(role)) {
          authorities.addLast(SimpleGrantedAuthority(authority))
        }
      }
      return authorities
    }
  */
}

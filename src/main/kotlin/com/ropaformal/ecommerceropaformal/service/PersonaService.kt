package com.ropaformal.ecommerceropaformal.service

import com.ropaformal.ecommerceropaformal.persistence.entity.PersonasEntity
import com.ropaformal.ecommerceropaformal.persistence.repository.PersonasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonaService {
  @Autowired
  private lateinit var personaRepository: PersonasRepository

  /**
   * Funcion buscar persona por id
   */
  fun getPersonaById(id: Int): PersonasEntity {
    return this.personaRepository.findById(id).get()
  }

  /**
   * Funcion para guardar una persona
   */
  fun save(personas: PersonasEntity): PersonasEntity {
    return this.personaRepository.save(personas)
  }

}

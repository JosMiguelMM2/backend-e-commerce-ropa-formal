package com.ropaformal.ecommerceropaformal.service

import com.ropaformal.ecommerceropaformal.persistence.entity.TipoDocumentosEntity
import com.ropaformal.ecommerceropaformal.persistence.repository.TipoDocumentosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TipoDocumentoService {
  @Autowired
  private lateinit var tipoDocumentosRepository: TipoDocumentosRepository

  fun getTipoDocumentos(id: Int): TipoDocumentosEntity {
    return this.tipoDocumentosRepository.findById(id).get()
  }
}

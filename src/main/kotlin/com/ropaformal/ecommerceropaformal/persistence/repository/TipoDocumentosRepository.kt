package com.ropaformal.ecommerceropaformal.persistence.repository

import com.ropaformal.ecommerceropaformal.persistence.entity.TipoDocumentoEntity
import org.springframework.data.repository.CrudRepository

interface TipoDocumentosRepository : CrudRepository<TipoDocumentoEntity, Int> {
}

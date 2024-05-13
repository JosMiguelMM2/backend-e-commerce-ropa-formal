package com.ropaformal.ecommerceropaformal.persistence.repository

import com.ropaformal.ecommerceropaformal.persistence.entity.TipoDocumentos
import org.springframework.data.repository.CrudRepository

interface TipoDocumentosRepository : CrudRepository<TipoDocumentos, Int> {
}

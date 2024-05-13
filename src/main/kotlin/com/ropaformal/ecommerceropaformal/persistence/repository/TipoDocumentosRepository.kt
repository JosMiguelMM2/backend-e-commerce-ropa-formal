package com.ropaformal.ecommerceropaformal.persistence.repository

import com.ropaformal.ecommerceropaformal.persistence.entity.TipoDocumentosEntity
import org.springframework.data.repository.CrudRepository

interface TipoDocumentosRepository : CrudRepository<TipoDocumentosEntity, Int> {
}

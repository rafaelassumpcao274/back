package com.unilith.Back.V1.Repository

import com.unilith.Back.V1.Entity.V1.Formato
import com.unilith.Back.V1.Entity.V1.Papel
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PapelRepository:JpaRepository<Papel,Long?>{
    fun findAllByDescricaoContaining(descricao:String, pageable: Pageable): List<Papel>
}
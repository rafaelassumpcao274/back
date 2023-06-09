package com.unilith.Back.V1.Repository

import com.unilith.Back.V1.Entity.V1.Empresa
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmpresaRepository: JpaRepository<Empresa,Long?>{
    fun findAllByNomeEmpresaContaining(nomeEmpresa:String, pageable: Pageable): List<Empresa>

}
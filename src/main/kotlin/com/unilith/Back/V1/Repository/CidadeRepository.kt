package com.unilith.Back.V1.Repository

import com.unilith.Back.V1.Entity.V1.Cidade
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CidadeRepository: JpaRepository<Cidade,Long?> {
     fun findOneByDescricaoEquals(descricao: String): Cidade
}
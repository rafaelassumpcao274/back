package com.unilith.Back.V1.Repository

import com.unilith.Back.V1.Entity.V1.Bairro
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BairroRepository:JpaRepository<Bairro,Long?>{

    fun findOneByDescricaoEquals(descricao:String):Bairro
}
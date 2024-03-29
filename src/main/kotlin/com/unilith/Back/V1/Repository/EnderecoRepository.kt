package com.unilith.Back.V1.Repository

import com.unilith.Back.V1.Entity.V1.Endereco
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EnderecoRepository:JpaRepository<Endereco,Long?>{

    fun findByCepOrDescricaoContains(cep:Int,descricao:String):Endereco

}
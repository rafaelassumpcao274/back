package com.unilith.Back.V1.Mapper.Custom

import com.unilith.Back.V1.Entity.V1.Endereco
import com.unilith.Back.V1.Mapper.ICustom.CustomMapper
import com.unilith.Back.V1.Vo.V1.EnderecoVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EnderecoMapper:CustomMapper<EnderecoVo,Endereco> {

    @Autowired
    lateinit var bairroMapper: BairroMapper

    override fun convertVo(entity: Endereco): EnderecoVo {
        val vo:EnderecoVo= EnderecoVo()

        vo.id = entity.id
        vo.descricao = entity.descricao
        vo.cep = entity.cep
        vo.numero= entity.numero
        vo.complemento = entity.complemento
        vo.bairro = entity.bairro?.let { bairroMapper.convertVo(it) }

        return vo
    }

    override fun convertEntity(vo: EnderecoVo): Endereco {
        val entity:Endereco = Endereco()

        entity.id = vo.id
        entity.descricao = vo.descricao
        entity.cep = vo.cep
        entity.numero= vo.numero
        entity.complemento = vo.complemento
        entity.bairro = vo.bairro?.let { bairroMapper.convertEntity(it) }

        return entity
    }


}
package com.unilith.Back.V1.Mapper.Custom

import com.unilith.Back.V1.Entity.V1.Bairro
import com.unilith.Back.V1.Mapper.ICustom.CustomMapper

import com.unilith.Back.V1.Vo.V1.BairroVo
import org.springframework.stereotype.Service

@Service
class BairroMapper : CustomMapper<BairroVo, Bairro> {

    lateinit var cidadeMapper: CidadeMapper
    override fun convertVo(entity: Bairro): BairroVo {
        val vo: BairroVo = BairroVo()

        vo.id = entity.id
        vo.descricao = entity.descricao
        vo.cidade = cidadeMapper.convertVo(entity.cidade)


        return vo;
    }

    override fun convertEntity(vo: BairroVo): Bairro {
        val entity: Bairro = Bairro()

        entity.id = vo.id
        entity.descricao = vo.descricao
        entity.cidade = cidadeMapper.convertEntity(vo.cidade)


        return entity;
    }


}
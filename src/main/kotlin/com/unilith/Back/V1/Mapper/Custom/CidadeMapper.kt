package com.unilith.Back.V1.Mapper.Custom

import com.unilith.Back.V1.Entity.V1.Cidade
import com.unilith.Back.V1.Mapper.ICustom.CustomMapper
import com.unilith.Back.V1.Vo.V1.CidadeVo
import org.springframework.stereotype.Service

@Service
class CidadeMapper : CustomMapper<CidadeVo, Cidade> {

    lateinit var ufMapper: UfMapper

    override fun convertVo(entity: Cidade): CidadeVo {
        val vo: CidadeVo = CidadeVo();

        vo.id = entity.id
        vo.descricao = entity.descricao
        vo.uf = ufMapper.convertVo(entity.uf)


        return vo
    }

    override fun convertEntity(vo: CidadeVo): Cidade {
        val entity: Cidade = Cidade();

        entity.id = vo.id
        entity.descricao = vo.descricao
        entity.uf = ufMapper.convertEntity(vo.uf)


        return entity
    }


}
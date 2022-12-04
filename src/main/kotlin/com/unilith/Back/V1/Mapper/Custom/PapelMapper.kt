package com.unilith.Back.V1.Mapper.Custom

import com.unilith.Back.V1.Entity.V1.Papel
import com.unilith.Back.V1.Mapper.ICustom.CustomMapper
import com.unilith.Back.V1.Vo.V1.PapelVo
import org.springframework.stereotype.Service

@Service
class PapelMapper : CustomMapper<PapelVo, Papel> {

    override fun convertVo(entity: Papel): PapelVo {
        val vo = PapelVo()

        vo.id = entity.id;
        vo.descricao =entity.descricao
        vo.quantidadePapel = entity.quantidadePapel

        return vo
    }

    override fun convertEntity(vo: PapelVo): Papel {
        val entity = Papel()

        entity.id = vo.id
        entity.descricao = vo.descricao
        entity.quantidadePapel = vo.quantidadePapel

        return entity
    }




}
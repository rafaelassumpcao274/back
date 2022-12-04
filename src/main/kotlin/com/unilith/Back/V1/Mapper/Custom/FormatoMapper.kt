package com.unilith.Back.V1.Mapper.Custom

import com.unilith.Back.V1.Entity.V1.Formato
import com.unilith.Back.V1.Mapper.ICustom.CustomMapper
import com.unilith.Back.V1.Vo.V1.FormatoVo
import org.springframework.stereotype.Service

@Service
class FormatoMapper : CustomMapper<FormatoVo, Formato> {
    override fun convertVo(entity: Formato): FormatoVo {
        val vo = FormatoVo();

        vo.id = entity.id
        vo.descricao = entity.descricao


        return vo;
    }

    override fun convertEntity(vo: FormatoVo): Formato {
        val entity = Formato();

         entity.id = vo.id
         entity.descricao = vo.descricao

        return entity;
    }

}
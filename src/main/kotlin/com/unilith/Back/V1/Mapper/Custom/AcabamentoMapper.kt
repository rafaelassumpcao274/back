package com.unilith.Back.V1.Mapper.Custom

import com.unilith.Back.V1.Entity.V1.Acabamento
import com.unilith.Back.V1.Mapper.ICustom.CustomMapper
import com.unilith.Back.V1.Util.AuditoriaUtil
import com.unilith.Back.V1.Vo.V1.AcabamentoVo

class AcabamentoMapper:CustomMapper<AcabamentoVo,Acabamento> {

    private lateinit var auditoriaUtil: AuditoriaUtil

    override fun convertVo(entity: Acabamento): AcabamentoVo {
        var vo:AcabamentoVo = AcabamentoVo()

        vo.id = entity.id
        vo.descricao = entity.descricao
        auditoriaUtil.convertVo(entity,vo)

        return vo;
    }

    override fun convertEntity(vo: AcabamentoVo): Acabamento {
        var entity:Acabamento = Acabamento()

        entity.id = vo.id
        entity.descricao = vo.descricao

        return entity;
    }


}
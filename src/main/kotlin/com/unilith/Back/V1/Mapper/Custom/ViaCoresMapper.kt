package com.unilith.Back.V1.Mapper.Custom

import com.unilith.Back.V1.Entity.V1.ViaCores
import com.unilith.Back.V1.Mapper.ICustom.CustomMapper
import com.unilith.Back.V1.Util.AuditoriaUtil
import com.unilith.Back.V1.Vo.V1.ViaCoresVo

class ViaCoresMapper:CustomMapper<ViaCoresVo,ViaCores> {

    lateinit var auditoriaUtil: AuditoriaUtil

    override fun convertVo(entity: ViaCores): ViaCoresVo {
        var vo:ViaCoresVo = ViaCoresVo()

        vo.id = entity.id
        vo.descricao = entity.descricao
        auditoriaUtil.convertVo(entity,vo)

        return vo
    }

    override fun convertEntity(vo: ViaCoresVo): ViaCores {
        var entity:ViaCores = ViaCores()

        entity.id = vo.id
        entity.descricao = vo.descricao

        return entity
    }
}
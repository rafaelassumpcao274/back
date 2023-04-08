package com.unilith.Back.V1.Mapper.Custom

import com.unilith.Back.V1.Entity.V1.Tinta
import com.unilith.Back.V1.Mapper.ICustom.CustomMapper
import com.unilith.Back.V1.Util.AuditoriaUtil
import com.unilith.Back.V1.Vo.V1.TintaVo


class TintaMapper:CustomMapper<TintaVo,Tinta> {

    lateinit var auditoriaUtil: AuditoriaUtil

    override fun convertVo(entity: Tinta): TintaVo {
        var vo:TintaVo = TintaVo()

        vo.id = entity.id
        vo.descricao = entity.descricao
        auditoriaUtil.convertVo(entity,vo)

        return vo
    }

    override fun convertEntity(vo: TintaVo): Tinta {
        var entity:Tinta = Tinta()

        entity.id = vo.id
        entity.descricao = vo.descricao

        return entity

    }
}
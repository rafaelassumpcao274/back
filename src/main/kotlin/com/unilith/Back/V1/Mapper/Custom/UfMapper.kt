package com.unilith.Back.V1.Mapper.Custom

import com.unilith.Back.V1.Entity.V1.Uf
import com.unilith.Back.V1.Mapper.ICustom.CustomMapper
import com.unilith.Back.V1.Vo.V1.UfVo

class UfMapper:CustomMapper<UfVo,Uf> {
    override fun convertVo(entity: Uf): UfVo {
        val vo:UfVo = UfVo()

        vo.id = entity.id
        vo.descricao = entity.descricao

        return vo
    }

    override fun convertEntity(vo: UfVo): Uf {
        val entity:Uf = Uf()

        entity.id = vo.id
        entity.descricao = vo.descricao


        return entity
    }


}
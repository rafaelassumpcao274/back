package com.unilith.Back.V1.Util

import com.unilith.Back.V1.Entity.V1.Auditoria
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuditoriaUtil{

    fun <T : Auditoria> save(objeto:T){
        objeto.createdAt = Date()
        objeto.userInc = "Alguem"
        this.update(objeto)
    }


    fun <T : Auditoria> update(objeto:T){

        objeto.updatedAt = Date()
        objeto.userUpdate = "Rafael"

    }


}
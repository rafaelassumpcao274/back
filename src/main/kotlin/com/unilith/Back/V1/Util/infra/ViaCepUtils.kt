package com.unilith.Back.V1.Util.infra

import org.springframework.stereotype.Service


@Service
class ViaCepUtils {


    fun removeCaracterInString(cep:String):String{
        return cep.replace(("[^\\d.]").toRegex(), "");
    }

}
package com.unilith.Back.V1.Util.port

import com.unilith.Back.V1.Vo.V1.EnderecoVo

interface ApiCepPort {
    fun buscarViaCep(cep:String): EnderecoVo
}
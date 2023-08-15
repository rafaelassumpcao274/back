package com.unilith.Back.V1.Vo.V1

import jakarta.persistence.Column


data class EnderecoVo(
    var id:Long = 0,
    var descricao:String = "",
    var cep:Int = 0,
    var numero: Int =0,
    var complemento: String = "",
    var bairro: BairroVo = BairroVo(),

):AuditoriaVo()

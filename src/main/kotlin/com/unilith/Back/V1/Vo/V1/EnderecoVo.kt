package com.unilith.Back.V1.Vo.V1


data class EnderecoVo(
    var id:Long = 0,
    var descricao:String = "",
    var cep:Int = 0,
    var bairro: BairroVo = BairroVo(),


):AuditoriaVo()

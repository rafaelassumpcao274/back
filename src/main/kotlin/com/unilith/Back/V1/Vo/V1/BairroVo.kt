package com.unilith.Back.V1.Vo.V1

data class BairroVo(
    var id:Long = 0,
    var descricao:String = "",
    var cidade:CidadeVo= CidadeVo(),

):AuditoriaVo()

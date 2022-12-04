package com.unilith.Back.V1.Vo.V1

data class CidadeVo(
    var id:Long =0,
    var descricao:String="",
    var uf:UfVo = UfVo(),

):AuditoriaVo()

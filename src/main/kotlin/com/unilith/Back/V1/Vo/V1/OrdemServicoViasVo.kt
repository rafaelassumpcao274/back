package com.unilith.Back.V1.Vo.V1

data class OrdemServicoViasVo(

    var id: Long = 0,
    var ordemServico: OrdemServicoVo = OrdemServicoVo(),
    var via: ViaCoresVo = ViaCoresVo(),
    var ordem: Int = 0,
):AuditoriaVo()

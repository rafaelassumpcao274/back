package com.unilith.Back.V1.Vo.V1

data class OrdemServicoViaCoresVo(

    var id: Long = 0,
    var ordemServico: OrdemServicoVo = OrdemServicoVo(),
    var via: ViaCoresVo = ViaCoresVo(),
):AuditoriaVo()

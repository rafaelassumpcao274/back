package com.unilith.Back.V1.Vo.V1

data class OrdemServico_viasVo(

    var id: Long = 0,
    var ordemServico: OrdemServicoVo = OrdemServicoVo(),
    var via: Vias_coresVo = Vias_coresVo(),
):AuditoriaVo()

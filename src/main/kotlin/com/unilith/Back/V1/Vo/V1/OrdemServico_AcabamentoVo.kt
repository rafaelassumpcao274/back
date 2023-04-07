package com.unilith.Back.V1.Vo.V1

data class OrdemServico_AcabamentoVo(

    var id: Long = 0,
    var ordemServico: OrdemServicoVo = OrdemServicoVo(),
    var acabamento: AcabamentoVo = AcabamentoVo(),

    ):AuditoriaVo()

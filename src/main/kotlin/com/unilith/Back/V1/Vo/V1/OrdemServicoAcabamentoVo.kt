package com.unilith.Back.V1.Vo.V1

data class OrdemServicoAcabamentoVo(

    var id: Long = 0,
    var ordemServico: OrdemServicoVo = OrdemServicoVo(),
    var acabamento: AcabamentoVo = AcabamentoVo(),

    ):AuditoriaVo()

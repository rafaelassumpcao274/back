package com.unilith.Back.V1.Vo.V1

import com.unilith.Back.V1.Enums.FrenteVerso

data class OrdemServicoTintaVo(


    var id: Long = 0,
    var ordemServico: OrdemServicoVo = OrdemServicoVo(),
    var tinta: TintaVo = TintaVo(),
    var frenteVerso: FrenteVerso = FrenteVerso.FRENTE

):AuditoriaVo()

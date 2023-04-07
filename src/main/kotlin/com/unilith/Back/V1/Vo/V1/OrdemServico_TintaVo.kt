package com.unilith.Back.V1.Vo.V1

import com.unilith.Back.V1.Enums.FrenteVerso

data class OrdemServico_TintaVo(


    var id: Long = 0,
    var ordemServico: OrdemServicoVo = OrdemServicoVo(),
    var tinta: TintaVo = TintaVo(),
    var freteVerso: FrenteVerso = FrenteVerso.FRENTE

):AuditoriaVo()

package com.unilith.Back.V1.Vo.V1

data class OrdemServicoVo(

    var id: Long = 0,
    var material: String ="",
    var quantidade_folhas: Int =0,
    var numeracao_ini: Int =0,
    var numeracao_final: Int =0,
    var observacao: String ="",
    var formato: FormatoVo = FormatoVo(),
    var cliente: EmpresaVo = EmpresaVo(),
    var papel: PapelVo = PapelVo(),

    var listaAcabamento:List<AcabamentoVo>? = ArrayList<AcabamentoVo>(),
    var listaTintas:List<TintaVo>? = ArrayList<TintaVo>(),
    var listaVias:List<Vias_coresVo>? = ArrayList<Vias_coresVo>()

):AuditoriaVo();
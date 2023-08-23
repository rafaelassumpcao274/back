package com.unilith.Back.V1.Vo.V1

data class OrdemServicoVo(

    var id: Long = 0,
    var material: String ="",
    var quantidadeFolhas: Int =0,
    var numeracaoIni: Int =0,
    var numeracaoFinal: Int =0,
    var observacao: String ="",
    var formato: FormatoVo = FormatoVo(),
    var empresa: EmpresaVo = EmpresaVo(),
    var papel: PapelVo = PapelVo(),

    var listaAcabamento:List<AcabamentoVo>? = ArrayList<AcabamentoVo>(),
    var listaTintas:List<TintaVo>? = ArrayList<TintaVo>(),
    var listaVias:List<ViaCoresVo>? = ArrayList<ViaCoresVo>()

):AuditoriaVo();
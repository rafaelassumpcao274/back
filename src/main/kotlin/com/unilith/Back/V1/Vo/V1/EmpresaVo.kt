package com.unilith.Back.V1.Vo.V1

data class EmpresaVo(


    val id:Long = 0,
    val nomeEmpresa:String = "",
    val razaoSocial:String = "",
    val cnpj:Int,
    val email:String?,
    val enderecoVo: EnderecoVo,
    val contato:String?,
    val telefone:Int?,


): AuditoriaVo()

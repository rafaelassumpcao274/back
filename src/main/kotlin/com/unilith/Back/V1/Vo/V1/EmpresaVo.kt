package com.unilith.Back.V1.Vo.V1

data class EmpresaVo(


    var id:Long = 0,
    var nomeEmpresa:String = "",
    var razaoSocial:String = "",
    var cnpj:Long = 0L,
    var email:String? = "",
    var endereco: EnderecoVo = EnderecoVo(),
    var contato:String? = "",
    var telefone:Int? = 0,


    ): AuditoriaVo()

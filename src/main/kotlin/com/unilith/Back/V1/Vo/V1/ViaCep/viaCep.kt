package com.unilith.Back.V1.Vo.V1.ViaCep

data class ViaCep(


    var cep: String = "",
    var logradouro: String = "",
    var complemento: String = "",
    var bairro: String = "",
    var localidade: String = "",
    var uf: String = "",
    var ibge: String = "",
    var gia: String = "",
    var ddd: String = "",
    var siafi: String = "",
    var erro:Boolean = false
)

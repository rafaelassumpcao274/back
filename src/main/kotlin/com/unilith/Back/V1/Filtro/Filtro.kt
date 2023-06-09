package com.unilith.Back.V1.Filtro

import java.util.*

data class Filtro (

    var id:Int? =0,

    var dataAte: Date? = Date(),
    var dataIni: Date? = Date(),
    var dataAteStr: String? = "",
    var dataIniStr: String? = "",

    var descricao:String = "",

    var limit:Int = 10,
    var page:Int = 0


        )
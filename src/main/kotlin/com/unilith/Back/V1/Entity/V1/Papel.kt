package com.unilith.Back.V1.Entity.V1

import jakarta.persistence.*

@Entity
@Table(name = "papel")
data class Papel (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long=0,

    @Column(name = "descricao", nullable = false, length = 80)
    var descricao:String= "",

    @Column(name = "quantidade_papel", nullable = false)
    var quantidadePapel:Int=0,


):Auditoria()
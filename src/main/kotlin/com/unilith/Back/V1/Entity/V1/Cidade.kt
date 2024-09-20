package com.unilith.Back.V1.Entity.V1

import jakarta.persistence.*

@Entity
@Table(name = "cidades")
data class Cidade(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long=0,

    @Column(name = "descricao_cidade", nullable = false, length = 80)
    var descricao:String= "",


    @OneToOne(optional=false)
    @JoinColumn(name = "uf_id", referencedColumnName = "id")
    var uf:Uf ? = Uf(),


):Auditoria()

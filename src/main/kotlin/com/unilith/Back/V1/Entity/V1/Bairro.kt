package com.unilith.Back.V1.Entity.V1

import jakarta.persistence.*


@Entity
@Table(name = "bairros")
data class Bairro(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "descricao_bairro", nullable = false, length = 50)
    var descricao: String ="",

    @ManyToOne()
    @JoinColumn(name = "cidade_id", referencedColumnName = "id",)
    var cidade:Cidade? = Cidade(),


):Auditoria()

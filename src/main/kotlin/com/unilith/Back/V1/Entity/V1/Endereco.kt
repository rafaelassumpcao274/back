package com.unilith.Back.V1.Entity.V1

import jakarta.persistence.*


@Entity
@Table(name = "enderecos")
data class Endereco(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "descricao_endereco", nullable = false, length = 50)
    var descricao: String ="",

    @Column(name = "cep", nullable = false, length = 50)
    var cep: Int =0,

    @Column(name = "numero", nullable = false, length = 50)
    var numero: Int =0,

    @Column(name = "complemento", nullable = false, length = 50)
    var complemento: String = "",

    @ManyToOne()
    @JoinColumn(name = "bairro_id", referencedColumnName = "id")
    var bairro:Bairro ?= Bairro(),


):Auditoria()

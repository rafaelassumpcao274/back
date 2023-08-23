package com.unilith.Back.V1.Entity.V1

import jakarta.persistence.*
import kotlin.jvm.Transient


@Entity
@Table(name = "ordem_de_servico")
data class OrdemServico (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "material", nullable = false, length = 50)
    var material: String ="",

    @Column(name = "quantidade_folhas", nullable = false, length = 50)
    var quantidade_folhas: Int =0,

    @Column(name = "numeracao_ini", nullable = false)
    var numeracao_ini: Int =0,

    @Column(name = "numeracao_final", nullable = false)
    var numeracao_final: Int =0,

    @Column(name = "observacao", nullable = false, length = 100)
    var observacao: String ="",

//    @ManyToOne()
//    @JoinColumn(name = "cor_frente", referencedColumnName = "id")
//    var cor_frente:Tinta= Tinta(),
//
//    @ManyToOne()
//    @JoinColumn(name = "cor_verso", referencedColumnName = "id")
//    var cor_verso:Tinta= Tinta(),

    @ManyToOne()
    @Transient
    @JoinColumn(name = "formato", referencedColumnName = "id")
    var formato:Formato= Formato(),

    @ManyToOne()
    @Transient
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    var empresa:Empresa= Empresa(),

    @ManyToOne()
    @Transient
    @JoinColumn(name = "papel", referencedColumnName = "id")
    var papel:Papel= Papel(),

    ):Auditoria()



package com.unilith.Back.V1.Entity.V1

import com.unilith.Back.V1.Enums.FrenteVerso
import jakarta.persistence.*
@Entity
@Table(name = "tinta")
data class Tinta(


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "descricao", nullable = false, length = 50)
    var descricao: String ="",

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "frenteVerso", nullable = false, length = 7)
    var frenteVerso: FrenteVerso = FrenteVerso.FRENTE

): Auditoria()

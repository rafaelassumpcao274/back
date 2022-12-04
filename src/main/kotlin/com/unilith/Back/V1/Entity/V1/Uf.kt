package com.unilith.Back.V1.Entity.V1

import jakarta.persistence.*

@Entity
@Table(name = "Uf")
data class Uf(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "descricao_uf", nullable = false, length = 2)
    var descricao: String ="",


): Auditoria()

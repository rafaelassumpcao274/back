package com.unilith.Back.V1.Entity.V1

import jakarta.persistence.*


@Entity
@Table(name = "via_cores")
data class ViaCores(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "descricao", nullable = false, length = 50)
    var descricao: String ="",


    ):Auditoria()

package com.unilith.Back.V1.Entity.V1



import jakarta.persistence.*

@Entity
@Table(name = "Formato")
data class Formato(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "descricao_formato", nullable = false, length = 80)
    var descricao: String = "",


):Auditoria()
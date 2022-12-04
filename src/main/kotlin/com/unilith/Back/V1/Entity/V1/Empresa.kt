package com.unilith.Back.V1.Entity.V1

import jakarta.persistence.*

@Entity
@Table(name = "empresas")
data class Empresa (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long = 0,

    @Column(name = "nome_empresa", nullable = false, length = 80)
    var nomeEmpresa:String = "",

    @Column(name = "razao_social", nullable = false, length = 80)
    var razaoSocial:String = "",

    @Column(name = "cnpj", nullable = false, length = 14)
    var cnpj:Int = 0,

    @Column(name = "email", nullable = true, length = 100)
    var email:String?= "",

    @OneToOne(optional=false)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    var endereco:Endereco = Endereco(),

    @Column(name = "contato", nullable = true, length = 100)
    var contato:String?="",

    @Column(name = "telefone", nullable = true, length = 50)
    var telefone:Int?= 0
    

    ): Auditoria() 

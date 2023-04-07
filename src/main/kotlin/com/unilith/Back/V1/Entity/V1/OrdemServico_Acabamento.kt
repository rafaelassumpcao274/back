package com.unilith.Back.V1.Entity.V1

import jakarta.persistence.*


@Entity
@Table(name = "ordemservico_acabamento")
data class OrdemServico_Acabamento(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @ManyToOne()
    @JoinColumn(name = "ordemServico", referencedColumnName = "id")
    var ordemServico:OrdemServico = OrdemServico(),

    @ManyToOne()
    @JoinColumn(name = "acabamento", referencedColumnName = "id")
    var acabamento: Acabamento = Acabamento(),


):Auditoria();

package com.unilith.Back.V1.Entity.V1

import jakarta.persistence.*


@Entity
@Table(name = "ordemservico_acabamento")
data class OrdemServicoAcabamento(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @ManyToOne()
    @JoinColumn(name = "ordem_servico", referencedColumnName = "id")
    var ordemServico:OrdemServico = OrdemServico(),

    @ManyToOne()
    @JoinColumn(name = "acabamento", referencedColumnName = "id")
    var acabamento: Acabamento = Acabamento(),


):Auditoria();

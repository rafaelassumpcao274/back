package com.unilith.Back.V1.Entity.V1

import jakarta.persistence.*


@Entity
@Table(name = "ordemservico_vias")
data class OrdemServicoViaCores(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,


    @ManyToOne()
    @JoinColumn(name = "ordem_servico", referencedColumnName = "id")
    var ordemServico:OrdemServico = OrdemServico(),

    @ManyToOne()
    @JoinColumn(name = "vias", referencedColumnName = "id")
    var via: ViaCores = ViaCores(),




    ):Auditoria()

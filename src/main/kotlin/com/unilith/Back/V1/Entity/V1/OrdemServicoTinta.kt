package com.unilith.Back.V1.Entity.V1

import com.unilith.Back.V1.Enums.FrenteVerso
import jakarta.persistence.*


@Entity
@Table(name = "ordemservico_tinta")
data class OrdemServicoTinta(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @ManyToOne()
    @JoinColumn(name = "ordem_servico", referencedColumnName = "id")
    var ordemServico:OrdemServico = OrdemServico(),

    @ManyToOne()
    @JoinColumn(name = "tinta", referencedColumnName = "id")
    var tinta: Tinta = Tinta(),



):Auditoria();

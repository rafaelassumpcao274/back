package com.unilith.Back.V1.Repository

import com.unilith.Back.V1.Entity.V1.OrdemServico
import com.unilith.Back.V1.Entity.V1.OrdemServicoAcabamento
import org.springframework.data.jpa.repository.JpaRepository

interface OrdemServicoAcabamentoRepository: JpaRepository<OrdemServicoAcabamento, Long?> {

     fun findAllByOrdemServico(ordemServico:OrdemServico): MutableList<OrdemServicoAcabamento>
}
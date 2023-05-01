package com.unilith.Back.V1.Repository

import com.unilith.Back.V1.Entity.V1.OrdemServico
import com.unilith.Back.V1.Entity.V1.OrdemServicoViaCores
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrdemServicoViaCoresRepository: JpaRepository<OrdemServicoViaCores, Long?> {
    
     fun findAllByOrdemServico(ordemServico: OrdemServico): List<OrdemServicoViaCores>
}
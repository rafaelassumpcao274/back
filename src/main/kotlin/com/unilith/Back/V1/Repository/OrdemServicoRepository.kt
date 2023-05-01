package com.unilith.Back.V1.Repository

import com.unilith.Back.V1.Entity.V1.OrdemServico
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrdemServicoRepository:JpaRepository<OrdemServico,Long?>{

}
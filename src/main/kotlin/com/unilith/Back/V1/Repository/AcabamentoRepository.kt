package com.unilith.Back.V1.Repository


import com.unilith.Back.V1.Entity.V1.Acabamento
import org.springframework.data.jpa.repository.JpaRepository

interface AcabamentoRepository: JpaRepository<Acabamento, Long?> {
}
package com.unilith.Back.V1.Repository

import com.unilith.Back.V1.Entity.V1.Formato
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface FormatoRepository: JpaRepository<Formato, Long?>
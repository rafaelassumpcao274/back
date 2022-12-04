package com.unilith.Back.V1.Repository

import com.unilith.Back.V1.Entity.V1.Papel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PapelRepository:JpaRepository<Papel,Long?>
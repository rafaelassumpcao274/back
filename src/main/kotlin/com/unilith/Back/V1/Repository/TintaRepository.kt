package com.unilith.Back.V1.Repository

import com.unilith.Back.V1.Entity.V1.Tinta
import org.springframework.data.jpa.repository.JpaRepository

interface TintaRepository:JpaRepository<Tinta,Long?> {
}
package com.unilith.Back.V1.Repository

import com.unilith.Back.V1.Entity.V1.Uf
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UfRepository:JpaRepository<Uf,Long?>
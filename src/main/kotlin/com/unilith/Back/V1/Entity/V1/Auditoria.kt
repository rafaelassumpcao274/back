package com.unilith.Back.V1.Entity.V1

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import java.util.*

@MappedSuperclass
open class Auditoria {

    @Column( nullable = false)
    var createdAt: Date? = Date()

    @Column( nullable = false)
    var updatedAt: Date? = Date()

    @Column( nullable = false)
    var userInc: String? = ""

    @Column( nullable = false)
    var userUpdate: String? = ""
}
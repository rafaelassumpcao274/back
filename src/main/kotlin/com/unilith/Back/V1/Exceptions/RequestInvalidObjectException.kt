package com.unilith.Back.V1.Exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class RequestInvalidObjectException:RuntimeException  {
    constructor(): super("Objeto invalido")
    constructor(exception: String?):super(exception)
}
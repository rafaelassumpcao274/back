package com.unilith.Back.V1.Exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class RequestObjectisNullException:RuntimeException {
    constructor(): super("Não e possivel criar objeto nulo")
    constructor(exception: String?):super(exception)
}
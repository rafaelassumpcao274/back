package com.unilith.Back.V1.Exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NO_CONTENT)
class RequestObjectNotFoundException :RuntimeException {

    constructor(): super("Objeto não encontrado !!")
    constructor(exception: String?):super(exception)
}
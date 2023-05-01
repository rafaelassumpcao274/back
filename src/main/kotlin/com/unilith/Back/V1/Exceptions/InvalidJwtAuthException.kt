package com.unilith.Back.V1.Exceptions

import org.springframework.http.HttpStatus
import org.springframework.security.core.AuthenticationException
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.FORBIDDEN)
class InvalidJwtAuthException(exception: String?): AuthenticationException(exception)

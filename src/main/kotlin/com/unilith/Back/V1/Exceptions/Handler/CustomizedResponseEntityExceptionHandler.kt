package br.com.erudio.exceptions.handler

import com.unilith.Back.V1.Exceptions.ExceptionResponse
import com.unilith.Back.V1.Exceptions.InvalidJwtAuthException
import com.unilith.Back.V1.Exceptions.RequestObjectisNullException
import com.unilith.Back.V1.Exceptions.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
@RestController
class CustomizedResponseEntityExceptionHandler : ResponseEntityExceptionHandler(){

    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest) :
            ResponseEntity<ExceptionResponse> {
        val exceptioResponse = ExceptionResponse(
            Date(),
            ex.message,
            request.getDescription(false)
        )
        return ResponseEntity<ExceptionResponse>(exceptioResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundExceptions(ex: Exception, request: WebRequest) :
            ResponseEntity<ExceptionResponse> {
        val exceptioResponse = ExceptionResponse(
            Date(),
            ex.message,
            request.getDescription(false)
        )
        return ResponseEntity<ExceptionResponse>(exceptioResponse, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(RequestObjectisNullException::class)
    fun handleBadRequestExceptions(ex: Exception, request: WebRequest) :
            ResponseEntity<ExceptionResponse> {
        val exceptioResponse = ExceptionResponse(
            Date(),
            ex.message,
            request.getDescription(false)
        )
        return ResponseEntity<ExceptionResponse>(exceptioResponse, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(InvalidJwtAuthException::class)
    fun handleInvalidJwtAuthenticationExceptions(ex: Exception, request: WebRequest) :
            ResponseEntity<ExceptionResponse> {
        val exceptioResponse = ExceptionResponse(
            Date(),
            ex.message,
            request.getDescription(false)
        )
        return ResponseEntity<ExceptionResponse>(exceptioResponse, HttpStatus.FORBIDDEN)
    }
}
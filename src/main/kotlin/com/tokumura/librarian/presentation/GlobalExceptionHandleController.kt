package com.tokumura.librarian.presentation

import com.tokumura.librarian.presentation.form.ErrorResponse
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.servlet.resource.NoResourceFoundException

@RestControllerAdvice
class GlobalExceptionHandleController {
    @ExceptionHandler(NoResourceFoundException::class)
    fun noResourceFoundExceptionHandler(e: NoResourceFoundException): ErrorResponse {
        return ErrorResponse("[${e.httpMethod}] /${e.resourcePath} endpoint not found")
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    fun noResourceFoundExceptionHandler(e: MethodArgumentTypeMismatchException): ErrorResponse {
        return ErrorResponse("Invalid argument")
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    fun noResourceFoundExceptionHandler(e: HttpRequestMethodNotSupportedException): ErrorResponse {
        return ErrorResponse("Invalid method")
    }
}
package com.miguel.apiusuarios.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

// Captura excepciones y responde con ApiError
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 404 Not Found.
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleNotFound(NoSuchElementException ex, HttpServletRequest req) {
        return new ApiError(404, "Not Found", ex.getMessage(), req.getRequestURI());
    }

    // 400 Bad Request (errores de validación).
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidation(MethodArgumentNotValidException ex, HttpServletRequest req) {
        String msg = ex.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(fe -> fe.getField() + ": " + fe.getDefaultMessage())
                .orElse("Datos inválidos");
        return new ApiError(400, "Bad Request", msg, req.getRequestURI());
    }

    // 400 Bad Request (genérico).
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleRuntime(RuntimeException ex, HttpServletRequest req) {
        return new ApiError(400, "Bad Request", ex.getMessage(), req.getRequestURI());
    }
}

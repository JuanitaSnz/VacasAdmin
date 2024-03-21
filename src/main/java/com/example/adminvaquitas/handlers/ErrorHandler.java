package com.example.adminvaquitas.handlers;

import com.example.adminvaquitas.exceptions.HttpException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ErrorHandler {

    /**
     * Maneja las excepciones del tipo HttpException y genera una respuesta con información detallada.
     *
     * @param ex Excepción de tipo HttpException.
     * @return ResponseEntity con un mapa que contiene el mensaje de error y el código de estado.
     * @since 1.0
     */
    @ExceptionHandler({HttpException.class})
    public ResponseEntity<Map<String, String>> handleException(HttpException ex) {
        Map<String, String> response = Map.of("error", ex.getMessage(), "status", "rejected");

        return new ResponseEntity<>(response, ex.getHttpCode());
    }
}

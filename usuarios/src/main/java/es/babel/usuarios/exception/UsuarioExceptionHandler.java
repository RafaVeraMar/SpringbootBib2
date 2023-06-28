package es.babel.usuarios.exception;

import es.babel.usuarios.web.dto.response.ErrorResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;7
@RestControllerAdvice
public class UsuarioExceptionHandler {
    // TODO completar este handler
    @ExceptionHandler(EntityNotFoundException.class)

public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
        final ErrorResponse error = ErrorResponse.builder().build();
    }
}

package es.babel.biblioteca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import es.babel.biblioteca.web.dto.response.ErrorResponse;
import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class BibliotecaExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
		final ErrorResponse error = ErrorResponse.builder()
				.status(HttpStatus.NOT_FOUND.value())
				.code(HttpStatus.NOT_FOUND.name())
				.message(ex.getMessage())
				.build();
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
}

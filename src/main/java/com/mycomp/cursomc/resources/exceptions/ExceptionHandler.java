package com.mycomp.cursomc.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.mycomp.cursomc.services.exceptions.DataIntegrityViolationExceptionCustom;
import com.mycomp.cursomc.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(com.mycomp.cursomc.services.exceptions.ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(HttpServletRequest request,
			ObjectNotFoundException objectNotFoundException) {

		String error = "Object Not Found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError standardError = new StandardError(Instant.now(), status.value(), error, objectNotFoundException.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status.value()).body(standardError);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(com.mycomp.cursomc.services.exceptions.DataIntegrityViolationExceptionCustom.class)
	public ResponseEntity<StandardError> dataIntegrityViolation(HttpServletRequest request,
			DataIntegrityViolationExceptionCustom dataIntegrityViolationException) {

		String error = "Violation of the data integrity";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError standardError = new StandardError(Instant.now(), status.value(), error, dataIntegrityViolationException.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status.value()).body(standardError);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> methodArgumentNotValid(HttpServletRequest request,
			MethodArgumentNotValidException methodArgumentNotValidException) {

		String error = "Method argument is not valid.";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ValidationError validationError = new ValidationError(Instant.now(), status.value(), error, "Erro de validação.",
				request.getRequestURI());

		for (FieldError x : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationError.addError(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(status.value()).body(validationError);
	}
}

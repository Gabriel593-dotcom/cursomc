package com.mycomp.cursomc.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		return handlerBuilder(error, status, objectNotFoundException, request);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(com.mycomp.cursomc.services.exceptions.DataIntegrityViolationExceptionCustom.class)
	public ResponseEntity<StandardError> dataIntegrityViolation(HttpServletRequest request,
			DataIntegrityViolationExceptionCustom dataIntegrityViolationException) {

		String error = "Violation of the data integrity";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return handlerBuilder(error, status, dataIntegrityViolationException, request);
	}

	private ResponseEntity<StandardError> handlerBuilder(String error, HttpStatus status, Exception e,
			HttpServletRequest request) {

		StandardError standardError = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status.value()).body(standardError);
	}

}

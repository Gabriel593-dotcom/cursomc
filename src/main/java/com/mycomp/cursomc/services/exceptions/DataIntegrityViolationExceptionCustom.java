package com.mycomp.cursomc.services.exceptions;

public class DataIntegrityViolationExceptionCustom extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataIntegrityViolationExceptionCustom(String message) {
		super(message);
	}

}

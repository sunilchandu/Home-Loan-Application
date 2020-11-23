package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ApplicationAlreadyExists.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> LoanAgreementNotFoundExceptionHandler(ApplicationAlreadyExists ex,
			WebRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(LocalDate.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ApplicationIdNotFound.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> LoanAgreementNotFoundExceptionHandler(ApplicationIdNotFound ex, WebRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(LocalDate.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Object> customValidationErrorHandling(MethodArgumentNotValidException ex,
			WebRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(LocalDate.now(), "validation error!",
				ex.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Object> globleExcpetionHandler(Exception ex, WebRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(LocalDate.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
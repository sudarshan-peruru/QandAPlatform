package com.sudarshan.qaplatform.exceptions;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatus status, WebRequest request){
		ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), "QAPlatform : MethodArgumentNotValid Exception in Global Exception handler", ex.getMessage());
		return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("hello");
		ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), "QAPlatform : Missing Path Variable", ex.getMessage());
		return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
		System.out.println("hello123");
		ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), "QAPlatform : Missing Path Variable", ex.getMessage());
		return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handleCompanyNotFoundException(EntityNotFoundException ex, WebRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<Object> handleInvalidInputException(InvalidInputException ex, WebRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
	}
}

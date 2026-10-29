package com.productapp.exception;

import java.time.LocalDateTime;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected @Nullable ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		// create an api errors objects
		ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(), status.value(), ex.getMessage(), status.toString());
		// pass the exosting status and body part that is apiErrors
		return ResponseEntity.status(status).body(apiErrors);
	}
   
	

	@Override
	protected @Nullable ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		LocalDateTime timestamp = LocalDateTime.now();
		int statusCode = status.value(); // returns the numerical value
		String message = ex.getMessage();
		String error = status.toString();

		// create an api errors objects
		ApiErrors apiErrors = new ApiErrors(timestamp, statusCode, message, error);
		// pass the exosting status and body part that is apiErrors
		return ResponseEntity.status(status).body(apiErrors);
	}

	@Override
	protected @Nullable ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		LocalDateTime timestamp = LocalDateTime.now();
		int statusCode = status.value(); // returns the numerical value
		String message = ex.getMessage();
		String error = status.toString();

		// create an api errors objects
		ApiErrors apiErrors = new ApiErrors(timestamp, statusCode, message, error);
		// pass the exosting status and body part that is apiErrors
		return ResponseEntity.status(status).body(apiErrors);
	}

	@Override
	protected @Nullable ResponseEntity<Object> handleMissingServletRequestParameter(
			MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status,
			WebRequest request) {
		LocalDateTime timestamp = LocalDateTime.now();
		int statusCode = status.value(); // returns the numerical value
		String message = ex.getMessage();
		String error = "Request Parameter is missing";

		// create an api errors objects
		ApiErrors apiErrors = new ApiErrors(timestamp, statusCode, message, error);
		// pass the exosting status and body part that is apiErrors
		return ResponseEntity.status(status).body(apiErrors);
	}

    //validation
	@Override
	protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		LocalDateTime timestamp = LocalDateTime.now();
		int statusCode = status.value(); // returns the numerical value
		String message = ex.getMessage();
		String error = status.toString();

		// create an api errors objects
		ApiErrors apiErrors = new ApiErrors(timestamp, statusCode, message, error);
		// pass the exosting status and body part that is apiErrors
		return ResponseEntity.status(status).body(apiErrors);
	}

	@Override
	protected @Nullable ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		LocalDateTime timestamp = LocalDateTime.now();
		int statusCode = status.value(); // returns the numerical value
		String message = ex.getMessage();
		String error = "The datatypes dont match";

		// create an api errors objects
		ApiErrors apiErrors = new ApiErrors(timestamp, statusCode, message, error);
		// pass the exosting status and body part that is apiErrors
		return ResponseEntity.status(status).body(apiErrors);
	}

	// handle custom exception
	@ExceptionHandler
	public ResponseEntity<Object> handleProductNotFound(ProductNotFoundException ex) {
		LocalDateTime timestamp = LocalDateTime.now();
		int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value(); // returns the numerical value 500
		String message = ex.getMessage(); // invalid id from the service class
		String error = "The id does not exist";
		// create an api errors objects
		ApiErrors apiErrors = new ApiErrors(timestamp, statusCode, message, error);
		// pass the exosting status and body part that is apiErrors
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiErrors);

	}

}

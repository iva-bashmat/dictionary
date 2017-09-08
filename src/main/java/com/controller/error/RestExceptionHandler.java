package com.controller.error;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(value = { ApiException.class })
	protected ResponseEntity<Object> handleConflict(ApiException exception) {
		List<ErrorWrapper> errorWrappers = new ArrayList<>();
		errorWrappers.add(new ErrorWrapper(exception));

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);

		return new ResponseEntity<Object>(errorWrappers, httpHeaders, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public ResponseEntity<Object> handleException(MethodArgumentNotValidException exception) {
		List<ErrorWrapper> errorWrappers = exception.getBindingResult().getFieldErrors().stream().map(ErrorWrapper::new)
		        .collect(Collectors.toList());

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);

		return new ResponseEntity<Object>(errorWrappers, httpHeaders, HttpStatus.BAD_REQUEST);
	}

}

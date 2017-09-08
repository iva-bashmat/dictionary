package com.controller.error;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {

	private static final long serialVersionUID = 1295383589584374883L;

	private HttpStatus status;
	
	private String fieldName;
	private Object invalidValue;

	public ApiException(HttpStatus status, String fieldName, Object invalidValue, String message) {
		super(message);
		this.status = status;
		this.fieldName = fieldName;
		this.invalidValue = invalidValue;
	}

	public ApiException(HttpStatus status, Object invalidValue, String message) {
		super(message);
		this.status = status;
		this.invalidValue = invalidValue;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Object getInvalidValue() {
		return invalidValue;
	}

	public void setInvalidValue(Object invalidValue) {
		this.invalidValue = invalidValue;
	}

}
package com.controller.error;

import org.springframework.validation.FieldError;

public class ErrorWrapper {

	private String fieldName;
	private Object invalidValue;
	private String message;

	public ErrorWrapper(FieldError fieldError) {
		this.fieldName = fieldError.getField();
		this.invalidValue = fieldError.getRejectedValue();
		this.message = fieldError.getDefaultMessage();
	}

	public ErrorWrapper(ApiException apiException) {
		this.fieldName = apiException.getFieldName();
		this.invalidValue = apiException.getInvalidValue();
		this.message = apiException.getMessage();
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

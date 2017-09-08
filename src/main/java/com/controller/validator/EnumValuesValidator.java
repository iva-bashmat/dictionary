package com.controller.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnumValuesValidator implements ConstraintValidator<EnumValues, String> {

	private String[] validValues;

	@Override
	public void initialize(EnumValues constraintAnnotation) {
		this.validValues = constraintAnnotation.enumValues();

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}
		for (String validValue : validValues) {
			if (validValue.equals(value)) {
				return true;
			}
		}
		return false;
	}

}

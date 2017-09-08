package com.controller.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EnumValuesValidatorTest {

	@Test
	public void testIsValid() {
		EnumValues enumValues = getEnumValues();

		EnumValuesValidator validator = new EnumValuesValidator();
		validator.initialize(enumValues);

		assertTrue(validator.isValid(null, null));
		assertTrue(validator.isValid("one", null));
		assertTrue(validator.isValid("two", null));

		assertFalse(validator.isValid("three", null));
		assertFalse(validator.isValid("ONE", null));
	}

	public EnumValues getEnumValues() {
		class TestClass {
			@EnumValues(enumValues = { "one", "two" })
			public String testField;
		}

		try {
			return TestClass.class.getField("testField").getAnnotation(EnumValues.class);
		} catch (NoSuchFieldException | SecurityException e) {
			throw new RuntimeException(String.format("%s cannot be created", EnumValues.class.getName()), e);
		}
	}

}

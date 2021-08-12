package ru.mail.java.junior.library.core.services.validators;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import ru.mail.java.junior.library.core.requests.RegisterReaderRequest;
import ru.mail.java.junior.library.core.responses.CoreError;

public class RegisterReaderRequestValidatorTest {

	private RegisterReaderRequestValidator validator = new RegisterReaderRequestValidator();

	@Test
	public void shouldReturnErrorWhenFirstNameIsNull() {
		RegisterReaderRequest request = new RegisterReaderRequest(null, "LastName");
		List<CoreError> errors = validator.validate(request);
		assertEquals(errors.size(), 1);
		assertEquals(errors.get(0).getField(), "firstName");
		assertEquals(errors.get(0).getMessage(), "Must not be empty!");
	}

	@Test
	public void shouldReturnErrorWhenLastNameIsNull() {
		RegisterReaderRequest request = new RegisterReaderRequest("FirstName", null);
		List<CoreError> errors = validator.validate(request);
		assertEquals(errors.size(), 1);
		assertEquals(errors.get(0).getField(), "lastName");
		assertEquals(errors.get(0).getMessage(), "Must not be empty!");
	}

	@Test
	public void shouldReturnErrorsWhenFirstNameAndLastNameIsNull() {
		RegisterReaderRequest request = new RegisterReaderRequest(null, null);
		List<CoreError> errors = validator.validate(request);
		assertEquals(errors.size(), 2);
	}

	@Test
	public void shouldSuccess() {
		RegisterReaderRequest request = new RegisterReaderRequest("FirstName", "LastName");
		List<CoreError> errors = validator.validate(request);
		assertEquals(errors.size(), 0);
	}

}
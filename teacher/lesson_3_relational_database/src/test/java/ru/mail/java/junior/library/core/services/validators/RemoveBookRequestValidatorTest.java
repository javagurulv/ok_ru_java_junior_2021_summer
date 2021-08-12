package ru.mail.java.junior.library.core.services.validators;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ru.mail.java.junior.library.core.requests.RemoveBookRequest;
import ru.mail.java.junior.library.core.responses.CoreError;

public class RemoveBookRequestValidatorTest {

	private RemoveBookRequestValidator validator = new RemoveBookRequestValidator();

	@Test
	public void shouldReturnErrorWhenTitleIsNull() {
		RemoveBookRequest request = new RemoveBookRequest(null);
		List<CoreError> errors = validator.validate(request);
		assertEquals(errors.size(), 1);
		assertEquals(errors.get(0).getField(), "bookId");
		assertEquals(errors.get(0).getMessage(), "Must not be empty!");
	}

	@Test
	public void shouldSuccess() {
		RemoveBookRequest request = new RemoveBookRequest(1L);
		List<CoreError> errors = validator.validate(request);
		assertEquals(errors.size(), 0);
	}

}
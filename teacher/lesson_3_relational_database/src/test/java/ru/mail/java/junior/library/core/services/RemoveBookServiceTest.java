package ru.mail.java.junior.library.core.services;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import ru.mail.java.junior.library.core.database.jpa.JpaBookRepository;
import ru.mail.java.junior.library.core.requests.RemoveBookRequest;
import ru.mail.java.junior.library.core.responses.CoreError;
import ru.mail.java.junior.library.core.responses.RemoveBookResponse;
import ru.mail.java.junior.library.core.services.validators.RemoveBookRequestValidator;

@RunWith(MockitoJUnitRunner.class)
public class RemoveBookServiceTest {

	@Mock private JpaBookRepository bookRepository;
	@Mock private RemoveBookRequestValidator validator;
	@InjectMocks private RemoveBookService service;

	@Test
	public void shouldReturnErrorWhenBookIdNotProvided() {
		RemoveBookRequest request = new RemoveBookRequest(null);
		List<CoreError> errors = new ArrayList<>();
		errors.add(new CoreError("bookId", "Must not be empty!"));
		Mockito.when(validator.validate(request)).thenReturn(errors);
		RemoveBookResponse response = service.execute(request);
		assertTrue(response.hasErrors());
		assertEquals(response.getErrors().size(), 1);
		assertEquals(response.getErrors().get(0).getField(), "bookId");
		assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
	}

	@Test
	public void shouldDeleteBookWithIdFromDatabase() {
		Mockito.when(validator.validate(any())).thenReturn(new ArrayList<>());
		RemoveBookRequest request = new RemoveBookRequest(1L);
		RemoveBookResponse response = service.execute(request);
		assertFalse(response.hasErrors());
		assertTrue(response.isBookRemoved());
	}

}
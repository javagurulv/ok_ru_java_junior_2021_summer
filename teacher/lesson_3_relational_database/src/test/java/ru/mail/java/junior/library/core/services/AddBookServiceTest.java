package ru.mail.java.junior.library.core.services;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import ru.mail.java.junior.library.core.database.jpa.JpaBookRepository;
import ru.mail.java.junior.library.core.requests.AddBookRequest;
import ru.mail.java.junior.library.core.responses.AddBookResponse;
import ru.mail.java.junior.library.core.responses.CoreError;
import ru.mail.java.junior.library.core.services.validators.AddBookRequestValidator;
import ru.mail.java.junior.library.core.matchers.BookMatcher;

@RunWith(MockitoJUnitRunner.class)
public class AddBookServiceTest {

	@Mock private JpaBookRepository bookRepository;
	@Mock private AddBookRequestValidator validator;
	@InjectMocks private AddBookService service;

	@Test
	public void shouldReturnResponseWithErrorsWhenValidationFails() {
		AddBookRequest request = new AddBookRequest(null, "Author");
		List<CoreError> errors = new ArrayList<>();
		errors.add(new CoreError("title", "Must not be empty!"));
		Mockito.when(validator.validate(request)).thenReturn(errors);

		AddBookResponse response = service.execute(request);
		assertTrue(response.hasErrors());
		assertEquals(response.getErrors().size(), 1);
		assertEquals(response.getErrors().get(0).getField(), "title");
		assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");

		Mockito.verifyNoInteractions(bookRepository);
	}

	@Test
	public void shouldAddBookToDatabase() {
		Mockito.when(validator.validate(any())).thenReturn(new ArrayList<>());
		AddBookRequest request = new AddBookRequest("Title", "Author");
		AddBookResponse response = service.execute(request);
		assertFalse(response.hasErrors());
		Mockito.verify(bookRepository).save(
				argThat(new BookMatcher("Title", "Author")));
	}

}
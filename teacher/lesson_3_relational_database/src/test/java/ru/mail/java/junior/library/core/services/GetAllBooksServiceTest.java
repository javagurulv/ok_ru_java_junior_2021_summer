package ru.mail.java.junior.library.core.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import ru.mail.java.junior.library.core.database.jpa.JpaBookRepository;
import ru.mail.java.junior.library.core.domain.Book;
import ru.mail.java.junior.library.core.requests.GetAllBooksRequest;
import ru.mail.java.junior.library.core.responses.GetAllBooksResponse;

@RunWith(MockitoJUnitRunner.class)
public class GetAllBooksServiceTest {

	@Mock private JpaBookRepository bookRepository;
	@InjectMocks private GetAllBooksService service;

	@Test
	public void shouldGetBooksFromDb() {
		List<Book> books = new ArrayList<>();
		books.add(new Book("Title", "Author"));
		Mockito.when(bookRepository.findAll()).thenReturn(books);

		GetAllBooksRequest request = new GetAllBooksRequest();
		GetAllBooksResponse response = service.execute(request);
		assertFalse(response.hasErrors());
		assertEquals(response.getBooks().size(), 1);
		assertEquals(response.getBooks().get(0).getTitle(), "Title");
		assertEquals(response.getBooks().get(0).getAuthor(), "Author");
	}

}
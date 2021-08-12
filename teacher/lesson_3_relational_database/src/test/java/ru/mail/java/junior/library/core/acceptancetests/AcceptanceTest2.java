package ru.mail.java.junior.library.core.acceptancetests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.mail.java.junior.library.core.DatabaseCleaner;
import ru.mail.java.junior.library.config.SpringCoreConfiguration;
import ru.mail.java.junior.library.core.requests.AddBookRequest;
import ru.mail.java.junior.library.core.requests.Ordering;
import ru.mail.java.junior.library.core.requests.Paging;
import ru.mail.java.junior.library.core.requests.SearchBooksRequest;
import ru.mail.java.junior.library.core.responses.SearchBooksResponse;
import ru.mail.java.junior.library.core.services.AddBookService;
import ru.mail.java.junior.library.core.services.SearchBooksService;

@Ignore
public class AcceptanceTest2 {

	private ApplicationContext appContext;

	@Before
	public void setup() {
		appContext = new AnnotationConfigApplicationContext(SpringCoreConfiguration.class);
		getDatabaseCleaner().clean();
	}

	@Test
	public void searchBooks() {
		AddBookRequest request1 = new AddBookRequest("Title", "Author1");
		getAddBookService().execute(request1);

		AddBookRequest request2 = new AddBookRequest("Title", "Author2");
		getAddBookService().execute(request2);

		SearchBooksRequest request3 = new SearchBooksRequest("Title", null);
		SearchBooksResponse response = getSearchBooksService().execute(request3);

		assertEquals(response.getBooks().size(), 2);
		assertEquals(response.getBooks().get(0).getTitle(), "Title");
		assertEquals(response.getBooks().get(0).getAuthor(), "Author1");
		assertEquals(response.getBooks().get(1).getTitle(), "Title");
		assertEquals(response.getBooks().get(1).getAuthor(), "Author2");
	}

	@Test
	public void searchBooksOrderingDescending() {
		AddBookRequest request1 = new AddBookRequest("Title", "Author1");
		getAddBookService().execute(request1);

		AddBookRequest request2 = new AddBookRequest("Title", "Author2");
		getAddBookService().execute(request2);

		Ordering ordering = new Ordering("author", "DESCENDING");
		SearchBooksRequest request3 = new SearchBooksRequest("Title", null, ordering);
		SearchBooksResponse response = getSearchBooksService().execute(request3);

		assertEquals(response.getBooks().size(), 2);
		assertEquals(response.getBooks().get(0).getTitle(), "Title");
		assertEquals(response.getBooks().get(0).getAuthor(), "Author2");
		assertEquals(response.getBooks().get(1).getTitle(), "Title");
		assertEquals(response.getBooks().get(1).getAuthor(), "Author1");
	}

	@Test
	public void searchBooksOrderingAscending() {
		AddBookRequest request1 = new AddBookRequest("Title", "Author1");
		getAddBookService().execute(request1);

		AddBookRequest request2 = new AddBookRequest("Title", "Author2");
		getAddBookService().execute(request2);

		Ordering ordering = new Ordering("author", "ASCENDING");
		SearchBooksRequest request3 = new SearchBooksRequest("Title", null, ordering);
		SearchBooksResponse response = getSearchBooksService().execute(request3);

		assertEquals(response.getBooks().size(), 2);
		assertEquals(response.getBooks().get(0).getTitle(), "Title");
		assertEquals(response.getBooks().get(0).getAuthor(), "Author1");
		assertEquals(response.getBooks().get(1).getTitle(), "Title");
		assertEquals(response.getBooks().get(1).getAuthor(), "Author2");
	}

	@Test
	public void searchBooksOrderingPaging() {
		AddBookRequest request1 = new AddBookRequest("Title", "Author1");
		getAddBookService().execute(request1);

		AddBookRequest request2 = new AddBookRequest("Title", "Author2");
		getAddBookService().execute(request2);

		Ordering ordering = new Ordering("author", "ASCENDING");
		Paging paging = new Paging(1, 1);
		SearchBooksRequest request3 = new SearchBooksRequest("Title", null, ordering, paging);
		SearchBooksResponse response = getSearchBooksService().execute(request3);

		assertEquals(response.getBooks().size(), 1);
		assertEquals(response.getBooks().get(0).getTitle(), "Title");
		assertEquals(response.getBooks().get(0).getAuthor(), "Author1");
	}

	private AddBookService getAddBookService() {
		return appContext.getBean(AddBookService.class);
	}

	private SearchBooksService getSearchBooksService() {
		return appContext.getBean(SearchBooksService.class);
	}

	private DatabaseCleaner getDatabaseCleaner() {
		return appContext.getBean(DatabaseCleaner.class);
	}

}

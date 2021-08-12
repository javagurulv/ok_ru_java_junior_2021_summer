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
import ru.mail.java.junior.library.core.requests.GetAllBooksRequest;
import ru.mail.java.junior.library.core.responses.GetAllBooksResponse;
import ru.mail.java.junior.library.core.services.AddBookService;
import ru.mail.java.junior.library.core.services.GetAllBooksService;

@Ignore
public class AcceptanceTest1 {

	private ApplicationContext appContext;

	@Before
	public void setup() {
		appContext = new AnnotationConfigApplicationContext(SpringCoreConfiguration.class);
		getDatabaseCleaner().clean();
	}

	@Test
	public void shouldReturnCorrectBookList() {
		AddBookRequest addBookRequest1 = new AddBookRequest("TitleA", "AuthorA");
		getAddBookService().execute(addBookRequest1);

		AddBookRequest addBookRequest2 = new AddBookRequest("TitleA", "AuthorA");
		getAddBookService().execute(addBookRequest2);

		GetAllBooksResponse response = getAllBooksService().execute(new GetAllBooksRequest());
		assertEquals(response.getBooks().size(), 2);
	}

	private AddBookService getAddBookService() {
		return appContext.getBean(AddBookService.class);
	}

	private GetAllBooksService getAllBooksService() {
		return appContext.getBean(GetAllBooksService.class);
	}

	private DatabaseCleaner getDatabaseCleaner() {
		return appContext.getBean(DatabaseCleaner.class);
	}

}

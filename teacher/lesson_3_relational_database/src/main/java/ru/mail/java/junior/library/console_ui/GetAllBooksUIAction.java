package ru.mail.java.junior.library.console_ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.mail.java.junior.library.core.requests.GetAllBooksRequest;
import ru.mail.java.junior.library.core.responses.GetAllBooksResponse;
import ru.mail.java.junior.library.core.services.GetAllBooksService;

@Component
public class GetAllBooksUIAction implements UIAction {

	@Autowired private GetAllBooksService getAllBooksService;

	@Override
	public void execute() {
		System.out.println("Book list: ");
		GetAllBooksRequest request = new GetAllBooksRequest();
		GetAllBooksResponse response = getAllBooksService.execute(request);
		response.getBooks().forEach(System.out::println);
		System.out.println("Book list end.");
	}
}
package ru.mail.java.junior.library.console_ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.mail.java.junior.library.core.domain.Book;
import ru.mail.java.junior.library.core.requests.UpdateBookRequest;
import ru.mail.java.junior.library.core.responses.UpdateBookResponse;
import ru.mail.java.junior.library.core.services.UpdateBookService;

@Component
public class UpdateBookUIAction implements UIAction {

	@Autowired private UpdateBookService updateBookService;

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter book id: ");
		Long bookId = Long.parseLong(scanner.nextLine());
		System.out.println("Enter new book title: ");
		String bookTitle = scanner.nextLine();
		System.out.println("Enter new book author: ");
		String bookAuthor = scanner.nextLine();

		UpdateBookRequest request = new UpdateBookRequest(bookId, bookTitle, bookAuthor);
		UpdateBookResponse response = updateBookService.execute(request);

		if (response.hasErrors()) {
			response.getErrors().forEach(coreError ->
				System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage())
			);
		} else {
			Book book = response.getUpdatedBook();
			System.out.println("New book id was: " + book.getId());
			System.out.println("New book author was: " + book.getAuthor());
			System.out.println("New book title was: " + book.getTitle());
			System.out.println("Your book was updated!");
		}
	}

}
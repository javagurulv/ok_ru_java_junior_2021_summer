package ru.mail.java.junior.library.core.responses;

import java.util.List;

import ru.mail.java.junior.library.core.domain.Book;

public class SearchBooksResponse extends CoreResponse {

	private List<Book> books;

	public SearchBooksResponse(List<Book> books, List<CoreError> errors) {
		super(errors);
		this.books = books;
	}

	public List<Book> getBooks() {
		return books;
	}
}

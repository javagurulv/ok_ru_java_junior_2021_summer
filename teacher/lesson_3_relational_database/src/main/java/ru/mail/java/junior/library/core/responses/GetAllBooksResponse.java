package ru.mail.java.junior.library.core.responses;

import java.util.List;

import ru.mail.java.junior.library.core.domain.Book;

public class GetAllBooksResponse extends CoreResponse {

	private List<Book> books;

	public GetAllBooksResponse(List<Book> books) {
		this.books = books;
	}

	public List<Book> getBooks() {
		return books;
	}
}

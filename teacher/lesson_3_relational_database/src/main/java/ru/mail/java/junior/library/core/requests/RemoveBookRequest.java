package ru.mail.java.junior.library.core.requests;

public class RemoveBookRequest {

	private Long bookId;

	public RemoveBookRequest(Long bookId) {
		this.bookId = bookId;
	}

	public Long getBookId() {
		return bookId;
	}
}

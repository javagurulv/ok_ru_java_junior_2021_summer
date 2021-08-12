package ru.mail.java.junior.library.core.requests;

public class UpdateBookRequest {

	private Long id;
	private String newTitle;
	private String newAuthor;

	public UpdateBookRequest() { }

	public UpdateBookRequest(Long id, String newTitle, String newAuthor) {
		this.id = id;
		this.newTitle = newTitle;
		this.newAuthor = newAuthor;
	}

	public Long getId() {
		return id;
	}

	public String getNewTitle() {
		return newTitle;
	}

	public String getNewAuthor() {
		return newAuthor;
	}
}
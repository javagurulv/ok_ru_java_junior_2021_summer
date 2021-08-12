package ru.mail.java.junior.library.core.requests;

public class DeleteBookRequest {

	private Long id;

	public DeleteBookRequest() { }

	public DeleteBookRequest(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}

package ru.mail.java.junior.library.core.requests;

public class GetBookRequest {

	private Long id;

	public GetBookRequest() { }

	public GetBookRequest(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}

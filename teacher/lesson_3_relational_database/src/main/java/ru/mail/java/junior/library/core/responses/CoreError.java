package ru.mail.java.junior.library.core.responses;

public class CoreError {

	private String field;
	private String message;

	public CoreError(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public String getMessage() {
		return message;
	}
}

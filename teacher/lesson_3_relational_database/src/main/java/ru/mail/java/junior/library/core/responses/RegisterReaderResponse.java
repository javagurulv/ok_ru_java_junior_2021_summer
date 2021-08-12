package ru.mail.java.junior.library.core.responses;

import java.util.List;

import ru.mail.java.junior.library.core.domain.Reader;

public class RegisterReaderResponse extends CoreResponse {

	private Reader newReader;

	public RegisterReaderResponse(List<CoreError> errors) {
		super(errors);
	}

	public RegisterReaderResponse(Reader newReader) {
		this.newReader = newReader;
	}

	public Reader getNewReader() {
		return newReader;
	}

}
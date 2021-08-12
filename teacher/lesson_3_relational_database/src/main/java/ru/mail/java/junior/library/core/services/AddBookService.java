package ru.mail.java.junior.library.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ru.mail.java.junior.library.core.database.jpa.JpaBookRepository;
import ru.mail.java.junior.library.core.domain.Book;
import ru.mail.java.junior.library.core.requests.AddBookRequest;
import ru.mail.java.junior.library.core.responses.AddBookResponse;
import ru.mail.java.junior.library.core.responses.CoreError;
import ru.mail.java.junior.library.core.services.validators.AddBookRequestValidator;

@Component
@Transactional
public class AddBookService {

	@Autowired private JpaBookRepository bookRepository;
	@Autowired private AddBookRequestValidator validator;

	public AddBookResponse execute(AddBookRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new AddBookResponse(errors);
		}

		Book book = new Book(request.getTitle(), request.getAuthor());
		bookRepository.save(book);

		return new AddBookResponse(book);
	}

}

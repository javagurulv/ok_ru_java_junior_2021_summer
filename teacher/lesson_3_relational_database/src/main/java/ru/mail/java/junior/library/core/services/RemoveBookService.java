package ru.mail.java.junior.library.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ru.mail.java.junior.library.core.database.jpa.JpaBookRepository;
import ru.mail.java.junior.library.core.requests.RemoveBookRequest;
import ru.mail.java.junior.library.core.responses.CoreError;
import ru.mail.java.junior.library.core.responses.RemoveBookResponse;
import ru.mail.java.junior.library.core.services.validators.RemoveBookRequestValidator;

@Component
@Transactional
public class RemoveBookService {

	@Autowired private JpaBookRepository bookRepository;
	@Autowired private RemoveBookRequestValidator validator;

	public RemoveBookResponse execute(RemoveBookRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new RemoveBookResponse(errors);
		}
		bookRepository.deleteById(request.getBookId());
		return new RemoveBookResponse(true);
	}

}
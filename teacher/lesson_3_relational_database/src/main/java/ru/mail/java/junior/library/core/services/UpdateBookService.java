package ru.mail.java.junior.library.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ru.mail.java.junior.library.core.database.jpa.JpaBookRepository;
import ru.mail.java.junior.library.core.requests.UpdateBookRequest;
import ru.mail.java.junior.library.core.responses.CoreError;
import ru.mail.java.junior.library.core.responses.UpdateBookResponse;
import ru.mail.java.junior.library.core.services.validators.UpdateBookRequestValidator;

@Component
@Transactional
public class UpdateBookService {

	@Autowired private JpaBookRepository bookRepository;
	@Autowired private UpdateBookRequestValidator validator;

	public UpdateBookResponse execute(UpdateBookRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new UpdateBookResponse(errors);
		}

		return bookRepository.findById(request.getId())
				.map(book -> {
					book.setTitle(request.getNewTitle());
					book.setAuthor(request.getNewAuthor());
					return new UpdateBookResponse(book);
				})
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new UpdateBookResponse(errors);
				});
	}

}
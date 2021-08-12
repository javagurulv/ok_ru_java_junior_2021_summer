package ru.mail.java.junior.library.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ru.mail.java.junior.library.core.database.jpa.JpaBookRepository;
import ru.mail.java.junior.library.core.requests.DeleteBookRequest;
import ru.mail.java.junior.library.core.responses.CoreError;
import ru.mail.java.junior.library.core.responses.DeleteBookResponse;
import ru.mail.java.junior.library.core.services.validators.DeleteBookValidator;

@Component
@Transactional
public class DeleteBookService {

	@Autowired private JpaBookRepository bookRepository;
	@Autowired private DeleteBookValidator validator;

	public DeleteBookResponse execute(DeleteBookRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new DeleteBookResponse(errors);
		}
		return bookRepository.findById(request.getId())
				.map(book -> {
					bookRepository.deleteById(request.getId());
					return new DeleteBookResponse(book);
				})
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new DeleteBookResponse(errors);
				});
	}

}
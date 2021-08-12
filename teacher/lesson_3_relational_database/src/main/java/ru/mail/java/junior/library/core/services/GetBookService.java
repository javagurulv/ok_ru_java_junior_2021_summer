package ru.mail.java.junior.library.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ru.mail.java.junior.library.core.database.jpa.JpaBookRepository;
import ru.mail.java.junior.library.core.requests.GetBookRequest;
import ru.mail.java.junior.library.core.responses.CoreError;
import ru.mail.java.junior.library.core.responses.GetBookResponse;
import ru.mail.java.junior.library.core.services.validators.GetBookValidator;

@Component
@Transactional
public class GetBookService {

	@Autowired private JpaBookRepository bookRepository;
	@Autowired private GetBookValidator validator;

	public GetBookResponse execute(GetBookRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new GetBookResponse(errors);
		}
		return bookRepository.findById(request.getId())
				.map(GetBookResponse::new)
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new GetBookResponse(errors);
				});
	}

}
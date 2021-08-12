package ru.mail.java.junior.library.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ru.mail.java.junior.library.core.database.jpa.JpaReaderRepository;
import ru.mail.java.junior.library.core.domain.Reader;
import ru.mail.java.junior.library.core.requests.RegisterReaderRequest;
import ru.mail.java.junior.library.core.responses.CoreError;
import ru.mail.java.junior.library.core.responses.RegisterReaderResponse;
import ru.mail.java.junior.library.core.services.validators.RegisterReaderRequestValidator;

@Component
@Transactional
public class RegisterReaderService {

	@Autowired private JpaReaderRepository readerRepository;
	@Autowired private RegisterReaderRequestValidator validator;

	public RegisterReaderResponse execute(RegisterReaderRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new RegisterReaderResponse(errors);
		}

		Reader reader = new Reader(request.getFirstName(), request.getLastName());
		readerRepository.save(reader);

		return new RegisterReaderResponse(reader);
	}

}
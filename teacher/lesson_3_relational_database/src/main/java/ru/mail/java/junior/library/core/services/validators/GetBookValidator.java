package ru.mail.java.junior.library.core.services.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import ru.mail.java.junior.library.core.requests.GetBookRequest;
import ru.mail.java.junior.library.core.responses.CoreError;

@Component
public class GetBookValidator {

	public List<CoreError> validate(GetBookRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateId(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateId(GetBookRequest request) {
		return (request.getId() == null)
				? Optional.of(new CoreError("id", "Must not be empty!"))
				: Optional.empty();
	}

}
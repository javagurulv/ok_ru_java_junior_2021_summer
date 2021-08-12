package ru.mail.java.junior.library.core.services.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import ru.mail.java.junior.library.core.requests.DeleteBookRequest;
import ru.mail.java.junior.library.core.responses.CoreError;

@Component
public class DeleteBookValidator {

	public List<CoreError> validate(DeleteBookRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateId(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateId(DeleteBookRequest request) {
		return (request.getId() == null)
				? Optional.of(new CoreError("id", "Must not be empty!"))
				: Optional.empty();
	}

}
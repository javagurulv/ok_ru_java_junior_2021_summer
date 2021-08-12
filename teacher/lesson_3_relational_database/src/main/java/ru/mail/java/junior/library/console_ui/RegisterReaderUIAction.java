package ru.mail.java.junior.library.console_ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.mail.java.junior.library.core.requests.RegisterReaderRequest;
import ru.mail.java.junior.library.core.responses.RegisterReaderResponse;
import ru.mail.java.junior.library.core.services.RegisterReaderService;

@Component
public class RegisterReaderUIAction implements UIAction {

	@Autowired private RegisterReaderService registerReaderService;

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter reader first name: ");
		String readerFirstName = scanner.nextLine();
		System.out.println("Enter reader last name: ");
		String readerLastName = scanner.nextLine();
		RegisterReaderRequest request = new RegisterReaderRequest(readerFirstName, readerLastName);
		RegisterReaderResponse response = registerReaderService.execute(request);

		if (response.hasErrors()) {
			response.getErrors().forEach(coreError ->
				System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage())
			);
		} else {
			System.out.println("New reader id was: " + response.getNewReader().getId());
			System.out.println("Reader was added to list.");
		}
	}

}
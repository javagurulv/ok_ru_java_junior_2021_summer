package ru.mail.java.junior.ddd.core.services.clients;

import ru.mail.java.junior.ddd.core.api.commands.clients.RegisterClientCommand;
import ru.mail.java.junior.ddd.core.api.commands.clients.RegisterClientResult;
import ru.mail.java.junior.ddd.common.dtos.ClientDTO;
import ru.mail.java.junior.ddd.core.domain.Client;
import ru.mail.java.junior.ddd.core.services.DomainCommandHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class RegisterClientCommandHandler
		implements DomainCommandHandler<RegisterClientCommand, RegisterClientResult> {

	@Autowired private ClientFactory clientFactory;
	@Autowired private ClientConverter clientConverter;


	@Override
	public RegisterClientResult execute(RegisterClientCommand command) {
		Client client = clientFactory.create(
				command.getLogin(),
				command.getPassword()
		);
		ClientDTO clientDTO = clientConverter.convert(client);
		return new RegisterClientResult(clientDTO);
	}

	@Override
	public Class getCommandType() {
		return RegisterClientCommand.class;
	}
	
}

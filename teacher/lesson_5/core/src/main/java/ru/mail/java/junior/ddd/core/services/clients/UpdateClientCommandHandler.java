package ru.mail.java.junior.ddd.core.services.clients;

import ru.mail.java.junior.ddd.core.api.commands.clients.UpdateClientCommand;
import ru.mail.java.junior.ddd.core.api.commands.clients.UpdateClientResult;
import ru.mail.java.junior.ddd.common.dtos.ClientDTO;
import ru.mail.java.junior.ddd.core.domain.Client;
import ru.mail.java.junior.ddd.core.services.DomainCommandHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class UpdateClientCommandHandler
        implements DomainCommandHandler<UpdateClientCommand, UpdateClientResult> {

    @Autowired private ClientService clientService;
    @Autowired private ClientConverter clientConverter;


    @Override
    public UpdateClientResult execute(UpdateClientCommand command) {
        Client client = clientService.update(
                command.getClientId(),
                command.getLogin(),
                command.getPassword()
        );
        ClientDTO clientDTO = clientConverter.convert(client);
        return new UpdateClientResult(clientDTO);
    }

    @Override
    public Class getCommandType() {
        return UpdateClientCommand.class;
    }

}

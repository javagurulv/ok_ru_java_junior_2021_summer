package ru.mail.java.junior.ddd.core.services.clients;

import ru.mail.java.junior.ddd.core.api.commands.clients.GetClientCommand;
import ru.mail.java.junior.ddd.core.api.commands.clients.GetClientResult;
import ru.mail.java.junior.ddd.common.dtos.ClientDTO;
import ru.mail.java.junior.ddd.core.domain.Client;
import ru.mail.java.junior.ddd.core.services.DomainCommandHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class GetClientCommandHandler
        implements DomainCommandHandler<GetClientCommand, GetClientResult> {

    @Autowired private ClientService clientService;
    @Autowired private ClientConverter clientConverter;


    @Override
    public GetClientResult execute(GetClientCommand command) {
        Client client = clientService.get(command.getClientId());
        ClientDTO clientDTO = clientConverter.convert(client);
        return new GetClientResult(clientDTO);
    }

    @Override
    public Class getCommandType() {
        return GetClientCommand.class;
    }

}

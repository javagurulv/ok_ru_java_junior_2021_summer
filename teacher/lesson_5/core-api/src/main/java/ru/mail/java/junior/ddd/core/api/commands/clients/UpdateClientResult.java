package ru.mail.java.junior.ddd.core.api.commands.clients;

import ru.mail.java.junior.ddd.core.api.commands.DomainCommandResult;
import ru.mail.java.junior.ddd.common.dtos.ClientDTO;

public class UpdateClientResult implements DomainCommandResult {

    private ClientDTO client;

    public UpdateClientResult(ClientDTO client) {
        this.client = client;
    }

    public ClientDTO getClient() {
        return client;
    }

}

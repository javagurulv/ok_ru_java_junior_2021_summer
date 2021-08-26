package ru.mail.java.junior.ddd.core.api.commands.clients;

import ru.mail.java.junior.ddd.core.api.commands.DomainCommandResult;
import ru.mail.java.junior.ddd.common.dtos.ClientDTO;

public class GetClientResult implements DomainCommandResult {

    private ClientDTO client;

    public GetClientResult(ClientDTO client) {
        this.client = client;
    }

    public ClientDTO getClient() {
        return client;
    }

}

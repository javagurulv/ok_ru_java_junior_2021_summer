package ru.mail.java.junior.ddd.core.api.commands.clients;

import ru.mail.java.junior.ddd.core.api.commands.DomainCommand;

public class GetClientCommand implements DomainCommand<GetClientResult> {

    private Long clientId;

    public GetClientCommand(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

}

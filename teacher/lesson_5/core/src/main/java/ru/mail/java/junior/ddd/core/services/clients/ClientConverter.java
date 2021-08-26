package ru.mail.java.junior.ddd.core.services.clients;

import ru.mail.java.junior.ddd.core.domain.Client;
import ru.mail.java.junior.ddd.common.dtos.ClientDTO;
import ru.mail.java.junior.ddd.common.dtos.ClientDTOBuilder;

import org.springframework.stereotype.Component;

@Component
class ClientConverter {

    public ClientDTO convert(Client client) {
        return ClientDTOBuilder.createClientDTO()
                .withId(client.getId())
                .withLogin(client.getLogin())
                .withPassword(client.getPassword()).build();
    }


}

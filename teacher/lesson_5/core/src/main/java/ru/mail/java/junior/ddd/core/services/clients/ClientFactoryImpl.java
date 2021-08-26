package ru.mail.java.junior.ddd.core.services.clients;

import ru.mail.java.junior.ddd.core.database.ClientRepository;
import ru.mail.java.junior.ddd.core.domain.Client;
import ru.mail.java.junior.ddd.core.domain.builders.ClientBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class ClientFactoryImpl implements ClientFactory {

    @Autowired private ClientValidator clientValidator;
    @Autowired private ClientRepository clientRepository;

    @Override
    public Client create(String login, String password) {
        clientValidator.validate(login, password);
        Client client = ClientBuilder.createClient()
                .withLogin(login)
                .withPassword(password)
                .build();
        return clientRepository.save(client);
    }

}

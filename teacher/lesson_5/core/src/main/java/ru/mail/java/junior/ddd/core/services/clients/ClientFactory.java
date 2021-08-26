package ru.mail.java.junior.ddd.core.services.clients;

import ru.mail.java.junior.ddd.core.domain.Client;

public interface ClientFactory {

    Client create(String login, String password);

}

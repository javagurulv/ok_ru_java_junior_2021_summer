package ru.mail.java.junior.ddd.core.services.clients;

import ru.mail.java.junior.ddd.core.domain.Client;

public interface ClientService {

    Client update(Long clientId,
				  String newLogin,
				  String newPassword);

    Client get(Long clientId);

}

package ru.mail.java.junior.ddd.core.domain.builders;

import ru.mail.java.junior.ddd.core.domain.Client;

public class ClientBuilder {

    private Long id;
    private String login;
    private String password;


    private ClientBuilder() {

    }

    public static ClientBuilder createClient() {
        return new ClientBuilder();
    }

    public Client build() {
        Client client = new Client();
        client.setId(id);
        client.setLogin(login);
        client.setPassword(password);
        return client;
    }

    public ClientBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ClientBuilder withLogin(String login) {
        this.login = login;
        return this;
    }

    public ClientBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

}

package ru.mail.java.junior.ddd.common.jms.requests.clients;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.mail.java.junior.ddd.common.dtos.ClientDTO;

public class JMSRegisterClientResponse {

    @JsonProperty("client")
    private ClientDTO client;


    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }
}

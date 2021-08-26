package ru.mail.java.junior.ddd.common.jms.requests.clients;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.mail.java.junior.ddd.common.dtos.ClientDTO;
import ru.mail.java.junior.ddd.common.jms.SupportedCommandId;
import ru.mail.java.junior.ddd.common.jms.requests.JMSAPIRequest;

public class JMSRegisterClientRequest implements JMSAPIRequest {

    @JsonProperty("client")
    private ClientDTO client;


    @Override
    public String getCommandId() {
        return SupportedCommandId.REGISTER_CLIENT;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }
}

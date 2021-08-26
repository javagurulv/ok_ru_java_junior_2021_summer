package ru.mail.java.junior.ddd.core.rest;

import ru.mail.java.junior.ddd.common.dtos.ClientDTO;
import ru.mail.java.junior.ddd.core.api.CommandExecutor;
import ru.mail.java.junior.ddd.core.api.commands.clients.RegisterClientCommand;
import ru.mail.java.junior.ddd.core.api.commands.clients.RegisterClientResult;
import ru.mail.java.junior.ddd.core.api.commands.clients.GetClientCommand;
import ru.mail.java.junior.ddd.core.api.commands.clients.GetClientResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(
        value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class ClientRestController {

    private CommandExecutor commandExecutor;

    @Autowired
    public ClientRestController(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @RequestMapping(method = RequestMethod.POST, value="/clients")
    @ResponseBody
    public ClientDTO create(ClientDTO clientDTO) {
        RegisterClientCommand command = new RegisterClientCommand(
                clientDTO.getLogin(), clientDTO.getPassword()
        );
        RegisterClientResult result = commandExecutor.execute(command);
        return result.getClient();
    }

    @GetMapping("/clients/{clientId}")
    @ResponseBody
    public ClientDTO get(@PathVariable("clientId") Long clientId) {
        GetClientCommand command = new GetClientCommand(clientId);
        GetClientResult result = commandExecutor.execute(command);
        return result.getClient();
    }

}

package ru.mail.java.junior.ddd.core.api.commands.clients;

import ru.mail.java.junior.ddd.core.api.commands.DomainCommand;

public class RegisterClientCommand implements DomainCommand<RegisterClientResult> {

    private String login;
    private String password;


    public RegisterClientCommand(String login,
                                 String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}

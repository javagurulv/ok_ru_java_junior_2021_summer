package ru.mail.java.junior.ddd.core.services;

import ru.mail.java.junior.ddd.core.api.commands.DomainCommand;
import ru.mail.java.junior.ddd.core.api.commands.DomainCommandResult;

public interface DomainCommandHandler<C extends DomainCommand, R extends DomainCommandResult> {

    R execute(C command);

    Class getCommandType();

}

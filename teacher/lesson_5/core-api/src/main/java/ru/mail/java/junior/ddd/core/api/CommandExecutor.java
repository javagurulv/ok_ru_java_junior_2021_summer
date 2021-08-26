package ru.mail.java.junior.ddd.core.api;

import ru.mail.java.junior.ddd.core.api.commands.DomainCommand;
import ru.mail.java.junior.ddd.core.api.commands.DomainCommandResult;

public interface CommandExecutor {

    <T extends DomainCommandResult> T execute(DomainCommand<T> domainCommand);

}

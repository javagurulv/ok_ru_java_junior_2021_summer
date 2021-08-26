package ru.mail.java.junior.ddd.core.api.commands;

public class VoidResult implements DomainCommandResult {

    public static final VoidResult INSTANCE = new VoidResult();

    private VoidResult() {

    }

}

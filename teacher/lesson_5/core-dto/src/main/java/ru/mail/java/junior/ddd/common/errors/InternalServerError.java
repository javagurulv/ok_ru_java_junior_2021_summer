package ru.mail.java.junior.ddd.common.errors;

import ru.mail.java.junior.ddd.common.ResponseStatus;

public class InternalServerError extends ApplicationException {

    public InternalServerError() {
        super(ResponseStatus.INTERNAL_SERVER_ERROR);
    }
}

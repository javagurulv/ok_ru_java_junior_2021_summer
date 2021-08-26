package ru.mail.java.junior.ddd.core.services.clients;

import ru.mail.java.junior.ddd.common.errors.ErrorCode;
import ru.mail.java.junior.ddd.common.errors.ErrorEmitter;
import ru.mail.java.junior.ddd.common.errors.ValidationError;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
class ClientValidatorImpl implements ClientValidator {

    @Override
    public void validate(String login, String password) {
        validateLogin(login);
        validatePassword(password);
    }

    private void validateLogin(String login) {
        if (login == null) {
            throw new ValidationError(
					ErrorCode.VALIDATION_MISSING_FIELD,
					"login",
					ErrorEmitter.CORE_APP
            );
        }
        if (StringUtils.isEmpty(login)) {
            throw new ValidationError(
                    ErrorCode.VALIDATION_INVALID_FIELD_VALUE,
                    "login",
                    ErrorEmitter.CORE_APP
            );
        }
    }

    private void validatePassword(String password) {
        if (password == null) {
            throw new ValidationError(
                    ErrorCode.VALIDATION_MISSING_FIELD,
                    "password",
                    ErrorEmitter.CORE_APP
            );
        }
        if (StringUtils.isEmpty(password)) {
            throw new ValidationError(
                    ErrorCode.VALIDATION_INVALID_FIELD_VALUE,
                    "password",
                    ErrorEmitter.CORE_APP
            );
        }
    }

}

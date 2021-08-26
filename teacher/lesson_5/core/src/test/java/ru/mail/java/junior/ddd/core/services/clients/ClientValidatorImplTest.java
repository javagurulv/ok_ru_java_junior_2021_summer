package ru.mail.java.junior.ddd.core.services.clients;

import ru.mail.java.junior.ddd.common.errors.ErrorCode;
import ru.mail.java.junior.ddd.common.errors.ErrorEmitter;
import ru.mail.java.junior.ddd.common.errors.ValidationError;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

public class ClientValidatorImplTest {

    private ClientValidator validator = new ClientValidatorImpl();

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void shouldThrowValidationExceptionWhenLoginIsNull() {
        thrown.expect(ValidationError.class);
        thrown.expect(hasProperty("errorCode", is(ErrorCode.VALIDATION_MISSING_FIELD)));
        thrown.expect(hasProperty("description", is("login")));
        thrown.expect(hasProperty("errorEmitter", is(ErrorEmitter.CORE_APP)));
        validator.validate(null, null);
    }

    @Test
    public void shouldThrowValidationExceptionWhenLoginIsEmpty() {
        thrown.expect(ValidationError.class);
        thrown.expect(hasProperty("errorCode", is(ErrorCode.VALIDATION_INVALID_FIELD_VALUE)));
        thrown.expect(hasProperty("description", is("login")));
        thrown.expect(hasProperty("errorEmitter", is(ErrorEmitter.CORE_APP)));
        validator.validate("", null);
    }

    @Test
    public void shouldThrowValidationExceptionWhenPasswordIsNull() {
        thrown.expect(ValidationError.class);
        thrown.expect(hasProperty("errorCode", is(ErrorCode.VALIDATION_MISSING_FIELD)));
        thrown.expect(hasProperty("description", is("password")));
        thrown.expect(hasProperty("errorEmitter", is(ErrorEmitter.CORE_APP)));
        validator.validate("login", null);
    }

    @Test
    public void shouldThrowValidationExceptionWhenPasswordIsEmpty() {
        thrown.expect(ValidationError.class);
        thrown.expect(hasProperty("errorCode", is(ErrorCode.VALIDATION_INVALID_FIELD_VALUE)));
        thrown.expect(hasProperty("description", is("password")));
        thrown.expect(hasProperty("errorEmitter", is(ErrorEmitter.CORE_APP)));
        validator.validate("login", "");
    }

}
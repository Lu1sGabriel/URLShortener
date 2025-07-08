package luis.goes.urlshortener.email;

import luis.goes.urlshortener.modules.valueObject.Email;
import luis.goes.urlshortener.core.exception.HttpException;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailTest {
    @Test
    void shouldCreateValidFullName() {
        final String validEmail = "email@example.com";
        Email email = new Email(validEmail);
        assertEquals(validEmail, email.getValue());
    }

    @Test
    void shouldThrowExceptionForNullableEmail() {
        Exception exception = assertThrows(HttpException.class, () -> new Email(null));
        assertThat(exception.getMessage(), CoreMatchers.containsString("Email must not be null."));
    }

    @Test
    void shouldThrowExceptionForInvalidEmail() {
        final String invalidEmail = "email.com";
        Exception exception = assertThrows(HttpException.class, () -> new Email(invalidEmail));
        assertThat(exception.getMessage(), CoreMatchers.containsString("Email invalid"));
    }
}

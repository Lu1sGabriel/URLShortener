package luis.goes.urlshortener.password;

import luis.goes.urlshortener.modules.valueObject.Password;
import luis.goes.urlshortener.core.exception.HttpException;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PasswordTest {

    @Test
    public void shouldCreateValidPassword() {
        final String validPassword = "@Senha123";
        Password password = new Password(validPassword);
        assertEquals(validPassword, password.getValue());

    }

    @Test
    public void shouldThrowExceptionForInvalidPassword() {
        final String invalidPassword = "senhaInvalida";
        Exception exception = assertThrows(HttpException.class, () -> new Password(invalidPassword));
        assertThat(exception.getMessage(), CoreMatchers.containsString("Password must contain at least one uppercase letter"));
    }

    @Test
    public void shouldThrowExceptionForInvalidPasswordLength() {
        final String invalidPassword = "curto";
        Exception exception = assertThrows(HttpException.class, () -> new Password(invalidPassword));
        assertThat(exception.getMessage(), CoreMatchers.containsString("Password must be at least 8 characters long."));
    }

    @Test
    public void shouldThrowExceptionForInvalidPasswordThatContainsÇ() {
        final String invalidPassword = "@Senha123Ç";
        Exception exception = assertThrows(HttpException.class, () -> new Password(invalidPassword));
        assertThat(exception.getMessage(), CoreMatchers.containsString("Password cannot contain the character 'ç' or 'Ç'."));
    }

}
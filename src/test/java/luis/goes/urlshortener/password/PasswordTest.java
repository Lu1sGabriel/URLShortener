package luis.goes.urlshortener.password;

import luis.goes.urlshortener.domain.valueObjects.Password;
import luis.goes.urlshortener.presentation.exception.ApiException;
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
        assertEquals(validPassword, password.password());

    }

    @Test
    public void shouldThrowExceptionForInvalidPassword() {
        final String invalidPassword = "senhaInvalida";
        Exception exception = assertThrows(ApiException.BadRequest.class, () -> new Password(invalidPassword));
        assertThat(exception.getMessage(), CoreMatchers.containsString("Password must contain at least one uppercase letter"));
    }

    @Test
    public void shouldThrowExceptionForInvalidPasswordLength() {
        final String invalidPassword = "curto";
        Exception exception = assertThrows(ApiException.BadRequest.class, () -> new Password(invalidPassword));
        assertThat(exception.getMessage(), CoreMatchers.containsString("Password must be at least 8 characters long."));
    }

    @Test
    public void shouldThrowExceptionForInvalidPasswordThatContainsÇ() {
        final String invalidPassword = "@Senha123Ç";
        Exception exception = assertThrows(ApiException.BadRequest.class, () -> new Password(invalidPassword));
        assertThat(exception.getMessage(), CoreMatchers.containsString("Password cannot contain the character 'ç' or 'Ç'."));
    }

}
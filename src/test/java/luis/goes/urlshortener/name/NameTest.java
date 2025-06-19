package luis.goes.urlshortener.name;

import luis.goes.urlshortener.domain.types.Name;
import luis.goes.urlshortener.presentation.exception.ApiException;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameTest {

    @Test
    void shouldCreateValidFullName() {
        final String fullName = "Luis Gabriel Goés de Santana";
        Name name = new Name(fullName);
        assertEquals(fullName, name.name());
    }

    @Test
    void shouldThrowExceptionForInvalidName() {
        final String invalidName = "Luis123!";

        Exception exception = assertThrows(ApiException.BadRequest.class, () -> new Name(invalidName));

        assertThat(exception.getMessage(), CoreMatchers.containsString("Name must contain only letters and spaces"));
    }
}

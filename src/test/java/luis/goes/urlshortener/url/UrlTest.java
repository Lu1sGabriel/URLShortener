package luis.goes.urlshortener.url;

import luis.goes.urlshortener.domain.valueObject.Url;
import luis.goes.urlshortener.presentation.exception.HttpException;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UrlTest {

    @Test
    void shouldCreateValidUrl() {
        final String validUrl = "www.google.com.br";
        Url url = new Url(validUrl);
        assertEquals(validUrl, url.getValue());
    }

    @Test
    void shouldThrowExceptionForNullUrl() {
        Exception exception = assertThrows(HttpException.class, () -> new Url(null));
        assertThat(exception.getMessage(), CoreMatchers.containsString("be null"));
    }

    @Test
    void shouldThrowExceptionForBlankUrl() {
        Exception exception = assertThrows(HttpException.class, () -> new Url("   "));
        assertThat(exception.getMessage(), CoreMatchers.containsString("be blank"));
    }

    @Test
    void shouldThrowExceptionForInvalidUrl() {
        final String invalidUrl = "ht!tp://invalid_url";

        Exception exception = assertThrows(HttpException.class, () -> new Url(invalidUrl));

        assertThat(exception.getMessage(), CoreMatchers.containsString("URL must start"));
    }

    @Test
    void shouldThrowExceptionForInvalidUrls() {
        final String[] invalidUrls = {
                "ww.google.com",         // www mal escrito
                "www.google",            // falta TLD
                "www.google.",           // ponto final sem TLD
                "htt://www.google.com",  // protocolo inválido
                "google.com",            // não começa com http(s) ou www
                "http://",               // sem domínio
                "http://google.t",       // TLD com uma letra
                "http://google.",        // ponto final sem TLD
                "https:/google.com",     // uma barra a menos
        };

        for (String url : invalidUrls) {
            assertThrows(HttpException.class, () -> new Url(url), "URL: " + url);
        }
    }

}


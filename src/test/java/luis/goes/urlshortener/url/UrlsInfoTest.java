package luis.goes.urlshortener.url;

import luis.goes.urlshortener.modules.url.valueObject.Url;
import luis.goes.urlshortener.core.exception.HttpException;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UrlsInfoTest {

    @Test
    void shouldCreateValidUrl() {
        final String validUrl = "https://www.youtube.com/watch?v=gE3hDK6pvBk&ab_channel=La%C3%A9rcioRefundini";
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
                "www.google.com/"        // faltando após a '/'
        };

        for (String url : invalidUrls) {
            assertThrows(HttpException.class, () -> new Url(url), "URL: " + url);
        }
    }

}
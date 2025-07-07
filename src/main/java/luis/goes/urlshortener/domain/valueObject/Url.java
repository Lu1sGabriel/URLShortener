package luis.goes.urlshortener.domain.valueObject;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import luis.goes.urlshortener.presentation.exception.HttpException;

import java.util.regex.Pattern;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public final class Url {

    private String url;

    private static final Pattern REGEX = Pattern.compile(
            "^(?:(http|https)://|www\\.)" +            // Prefixo http, https ou www
                    "([a-zA-Z0-9-]+\\.)+" +                    // Domínio(s) como "google." ou "youtube."
                    "([a-zA-Z]{2,})" +                         // TLD com 2 ou mais letras
                    "([/?#].*)?$"                              // Opcional: /path, ?query, #fragment
    );

    public Url(String url) {
        this.url = validate(url);
    }

    private String validate(String url) {
        if (url == null) throw HttpException.badRequest("URL must not be null");
        if (StringUtils.isBlank(url)) throw HttpException.badRequest("URL must not be blank");

        String trimmed = url.trim();

        boolean hasValidPrefix = trimmed.startsWith("http://") || trimmed.startsWith("https://") || trimmed.startsWith("www.");
        if (!hasValidPrefix) throw HttpException.badRequest("URL must start with http://, https:// or www.");

        if (!REGEX.matcher(trimmed).matches()) {
            throw HttpException.badRequest("Invalid URL");
        }

        return trimmed;
    }

    public String getValue() {
        return url;
    }

}
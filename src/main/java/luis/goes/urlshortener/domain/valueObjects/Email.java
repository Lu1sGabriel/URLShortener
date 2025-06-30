package luis.goes.urlshortener.domain.valueObjects;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.Embeddable;
import luis.goes.urlshortener.presentation.exception.HttpException;

import java.util.regex.Pattern;

@Embeddable
public record Email(String email) {
    private static final Pattern REGEX = Pattern.compile(
            "^(?=.{1,254}$)(?=.{1,64}@)[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+" +
                    "(\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@" +
                    "([a-zA-Z0-9]([a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+" +
                    "[a-zA-Z]{2,}$"
    );

    public Email {
        email = validate(email);
    }

    private String validate(String email) {
        if (email == null) throw HttpException.badRequest("Email must not be null.");

        if (StringUtils.isBlank(email)) throw HttpException.badRequest("Email must no be blank");

        if (!REGEX.matcher(email).matches()) throw HttpException.badRequest("Email invalid.");

        return email;
    }

}
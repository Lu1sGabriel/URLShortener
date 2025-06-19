package luis.goes.urlshortener.domain.types;

import jakarta.persistence.Embeddable;
import luis.goes.urlshortener.presentation.exception.ApiException;

import java.util.regex.Pattern;

@Embeddable
public record Email(String email) {
    private static final Pattern REGEX = Pattern.compile(
            "^(?=.{1,254}$)(?=.{1,64}@)[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+" +
                    "(\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@" +
                    "([a-zA-Z0-9]([a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+" +
                    "[a-zA-Z]{2,}$"
    );

    public Email(String email) {
        this.email = validate(email);
    }

    private String validate(String email) {
        if (email == null) {
            throw new ApiException.BadRequest("Email cannot be null.");
        }
        if (REGEX.matcher(email).matches()) {
            return email;
        }
        throw new ApiException.BadRequest("Email invalid.");
    }

}
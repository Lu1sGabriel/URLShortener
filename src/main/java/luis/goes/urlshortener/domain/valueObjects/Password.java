package luis.goes.urlshortener.domain.valueObjects;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.Embeddable;
import luis.goes.urlshortener.presentation.exception.HttpException;
import luis.goes.urlshortener.shared.utils.PasswordHashUtil;

import java.util.regex.Pattern;

@Embeddable
public record Password(String password) {
    private static final Pattern REGEX = Pattern.compile(
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\w\\sÇç])[\\S]*$"
    );

    public Password {
        password = hashPasswordAfterIsValid(password);
    }

    private String hashPasswordAfterIsValid(String password) {
        return PasswordHashUtil.hash(validate(password));
    }

    private String validate(String password) {

        if (password == null) throw HttpException.badRequest("Password must not be null.");

        if (StringUtils.isBlank(password)) throw HttpException.badRequest("Password must not be blank.");

        if (password.length() < 8) throw HttpException.badRequest("Password must be at least 8 characters long.");

        if (password.toLowerCase().contains("ç")) throw HttpException.badRequest("Password cannot contain the character 'ç' or 'Ç'.");

        if (!REGEX.matcher(password).matches()) throw HttpException.badRequest("Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character.");

        return password;
    }

}
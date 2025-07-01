package luis.goes.urlshortener.domain.valueObjects;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import luis.goes.urlshortener.presentation.exception.HttpException;
import luis.goes.urlshortener.shared.utils.PasswordHashUtil;

import java.util.regex.Pattern;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public final class Password {

    private static final Pattern REGEX = Pattern.compile(
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\w\\sÇç])[\\S]*$"
    );

    private String password;

    public Password(String rawPassword) {
        this.password = hashPasswordAfterValidation(rawPassword);
    }

    private String hashPasswordAfterValidation(String password) {
        return PasswordHashUtil.hash(validate(password));
    }

    private String validate(String password) {
        System.out.println("Entrou na senha");

        if (password == null)
            throw HttpException.badRequest("Password must not be null.");

        if (StringUtils.isBlank(password))
            throw HttpException.badRequest("Password must not be blank.");

        if (password.length() < 8)
            throw HttpException.badRequest("Password must be at least 8 characters long.");

        if (password.toLowerCase().contains("ç"))
            throw HttpException.badRequest("Password cannot contain the character 'ç' or 'Ç'.");

        if (!REGEX.matcher(password).matches())
            throw HttpException.badRequest("Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character.");

        return password;
    }

    public String getValue() {
        return password;
    }

    @Override
    public String toString() {
        return "[PROTECTED]";
    }

}

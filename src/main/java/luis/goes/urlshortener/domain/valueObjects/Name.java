package luis.goes.urlshortener.domain.valueObjects;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import luis.goes.urlshortener.presentation.exception.HttpException;
import luis.goes.urlshortener.shared.utils.NameFormatter;

import java.util.regex.Pattern;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public class Name {
    private String name;
    private static final Pattern REGEX = Pattern.compile(
            "^[a-zà-öø-ÿ\\s]+$", Pattern.CASE_INSENSITIVE
    );

    public Name (String name){
        this.name = validate(name);
    }

    private String validate(String name) {
        System.out.println("Entrou no nome");

        if (name == null) throw HttpException.badRequest("Name is required.");

        if (StringUtils.isBlank(name)) throw HttpException.badRequest("Name cannot be blank.");

        if (name.length() < 2) throw HttpException.badRequest("Name must have 2 or more characters.");

        if (!REGEX.matcher(name).matches()) throw HttpException.badRequest("Invalid name.");

        return NameFormatter.format(name);
    }

    public String getValue() {
        return name;
    }

}
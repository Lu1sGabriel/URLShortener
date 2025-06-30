package luis.goes.urlshortener.domain.valueObjects;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.Embeddable;
import luis.goes.urlshortener.presentation.exception.ApiException;
import luis.goes.urlshortener.shared.utils.NameFormatter;

import java.util.regex.Pattern;

@Embeddable
public record Name(String name) {

    private static final Pattern REGEX = Pattern.compile("^[A-Za-zÀ-ÖØ-öø-ÿ\\s]{2,60}$", Pattern.CASE_INSENSITIVE);

    public Name {
        name = validate(name);
    }

    private String validate(String name) {
        if (name == null) throw new ApiException.BadRequest("Name is required.");

        if (StringUtils.isBlank(name)) throw new ApiException.BadRequest("Name cannot be blank.");

        if (!REGEX.matcher(name).matches()) throw new ApiException.BadRequest("Invalid name.");

        return NameFormatter.format(name);
    }

}
package luis.goes.urlshortener.modules.valueObject;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import luis.goes.urlshortener.core.exception.HttpException;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public class Description {

    private String description;

    private static final int MIN_LENGTH = 10;
    private static final int MAX_LENGTH = 255;

    public Description(String description) {
        this.description = validate(description);
    }

    private String validate(String description) {
        if (description == null) throw HttpException.badRequest("Description is required.");

        if (StringUtils.isBlank(description)) throw HttpException.badRequest("Description cannot be empty or whitespace.");

        if (description.length() < MIN_LENGTH)
            throw HttpException.badRequest("Description must be at least " + MIN_LENGTH + " characters long.");

        if (description.length() > MAX_LENGTH)
            throw HttpException.badRequest("Description must be no more than " + MAX_LENGTH + " characters long.");

        return description.trim().replaceAll("\\s{2,}", " ");
    }

    public String getValue() {
        return description;
    }

}
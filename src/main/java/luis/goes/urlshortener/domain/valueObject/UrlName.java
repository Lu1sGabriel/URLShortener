package luis.goes.urlshortener.domain.valueObject;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import luis.goes.urlshortener.presentation.exception.HttpException;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public final class UrlName {

    private String name;

    public UrlName(String name) {
        this.name = validate(name);
    }

    private String validate(String name) {
        if (name == null) throw HttpException.badRequest("Name must not be null.");
        if (StringUtils.isBlank(name)) throw HttpException.badRequest("Name must not be blank.");
        if (name.length() < 2) throw HttpException.badRequest("Name must be at least 2 characters long.");
        return name;
    }

    public String getValue() {
        return name;
    }

}
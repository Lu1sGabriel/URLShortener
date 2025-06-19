package luis.goes.urlshortener.shared.types;

import jakarta.persistence.Embeddable;

import java.util.regex.Pattern;

@Embeddable
public record Name(String name) {

    private static final Pattern REGEX = Pattern.compile("^[A-Za-zÀ-ÖØ-öø-ÿ\\s]{2,60}$", Pattern.CASE_INSENSITIVE);

    public Name(String name) {
        this.name = validate(name);
    }

    private String validate(String name) {
        if (REGEX.matcher(name).matches()) {
            return name;
        }
        throw new IllegalArgumentException("Name must contain only letters and spaces (2–60 characters).");
    }

}
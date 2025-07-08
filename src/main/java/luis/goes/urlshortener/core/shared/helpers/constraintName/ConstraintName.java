package luis.goes.urlshortener.core.shared.helpers.constraintName;

import lombok.Getter;

@Getter
public enum ConstraintName {
    UK_USER_NAME("uk_user_name", "name"),
    UK_USER_MAIL("uk_user_email", "email"),
    UK_ROLE_NAME("uk_role_name", "name");

    private final String constraint;
    private final String field;

    ConstraintName(String constraint, String field) {
        this.constraint = constraint;
        this.field = field;
    }

}
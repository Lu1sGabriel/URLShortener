package luis.goes.urlshortener.shared.helpers;

public enum ConstraintName {
    UK_USER_NAME("uk_user_name", "name"),
    UK_USER_MAIL("uk_user_email", "email");

    private final String constraint;
    private final String field;

    ConstraintName(String constraint, String field) {
        this.constraint = constraint;
        this.field = field;
    }

    public String getConstraint() {
        return constraint;
    }

    public String getField() {
        return field;
    }
}

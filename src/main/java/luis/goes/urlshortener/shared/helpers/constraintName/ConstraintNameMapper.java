package luis.goes.urlshortener.shared.helpers.constraintName;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ConstraintNameMapper {

    private static final Map<String, String> CONSTRAINT_TO_FIELD = Arrays.stream(ConstraintName.values())
            .collect(Collectors.toMap(ConstraintName::getConstraint, ConstraintName::getField));

    public static String getFieldName(String constraintName) {
        return CONSTRAINT_TO_FIELD.getOrDefault(constraintName, "unknown");
    }

}
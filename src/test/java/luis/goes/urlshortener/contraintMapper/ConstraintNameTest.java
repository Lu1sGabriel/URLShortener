package luis.goes.urlshortener.contraintMapper;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;
import java.util.stream.Collectors;

import luis.goes.urlshortener.shared.helpers.constraintName.ConstraintName;
import org.junit.jupiter.api.Test;

public class ConstraintNameTest {

    @Test
    public void shouldNotHaveDuplicateConstraintOrField() {
        ConstraintName[] values = ConstraintName.values();

        // Checa duplicação em constraint
        Set<String> distinctConstraints = new HashSet<>();
        List<String> duplicateConstraints = Arrays.stream(values)
                .map(ConstraintName::getConstraint)
                .filter(c -> !distinctConstraints.add(c)) // retorna true se já existia (duplicado)
                .collect(Collectors.toList());

        // Checa duplicação em field
        Set<String> distinctFields = new HashSet<>();
        List<String> duplicateFields = Arrays.stream(values)
                .map(ConstraintName::getField)
                .filter(f -> !distinctFields.add(f))
                .collect(Collectors.toList());

        String errorMessage = "";
        if (!duplicateConstraints.isEmpty()) {
            errorMessage += "Duplicate constraints found: " + duplicateConstraints + ". ";
        }
        if (!duplicateFields.isEmpty()) {
            errorMessage += "Duplicate fields found: " + duplicateFields + ".";
        }

        assertTrue(errorMessage.isEmpty(), errorMessage);
    }
}

package luis.goes.urlshortener.shared.utils;

import jakarta.annotation.PostConstruct;
import luis.goes.urlshortener.shared.helpers.constraintName.ConstraintName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ConstraintNameValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConstraintNameValidator.class);

    @PostConstruct
    public void validateUniqueConstraints() {
        Map<String, Long> constraintCounts = Arrays.stream(ConstraintName.values())
                .collect(Collectors.groupingBy(ConstraintName::getConstraint, Collectors.counting()));

        Map<String, Long> fieldCounts = Arrays.stream(ConstraintName.values())
                .collect(Collectors.groupingBy(ConstraintName::getField, Collectors.counting()));

        List<String> duplicateConstraints = constraintCounts.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

        List<String> duplicateFields = fieldCounts.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

        if (!duplicateConstraints.isEmpty() || !duplicateFields.isEmpty()) {
            StringBuilder sb = new StringBuilder("\n[CONSTRAINTS VALIDATION FAILED]\n");
            if (!duplicateConstraints.isEmpty()) {
                sb.append("Duplicated constraint names:\n");
                duplicateConstraints.forEach(c -> sb.append("  - ").append(c).append("\n"));
            }
            if (!duplicateFields.isEmpty()) {
                sb.append("Duplicated field names:\n");
                duplicateFields.forEach(f -> sb.append("  - ").append(f).append("\n"));
            }
            sb.append("Please fix these duplicates before running the application.\n");

            // Log em erro para ser bem visível
            LOGGER.error(sb.toString());

            // Lança exceção pra parar startup (opcional)
            throw new IllegalStateException(sb.toString());
        }

        LOGGER.info("ConstraintName validation passed with no duplicates.");
    }

}
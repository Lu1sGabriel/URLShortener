package luis.goes.urlshortener.presentation.dtos.role;

import luis.goes.urlshortener.presentation.dtos.DTO;

import java.util.List;
import java.util.UUID;

public record RoleResponseDTO(
        UUID id,
        String name,
        String description,
        List<Users> users
) implements DTO {
    public record Users(
            UUID id,
            String name,
            String email
    ) {
    }
}
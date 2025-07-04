package luis.goes.urlshortener.presentation.dtos.role;

import luis.goes.urlshortener.presentation.dtos.DTO;

public record RoleRequestDTO(
        String name,
        String description
) implements DTO {
}
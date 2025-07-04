package luis.goes.urlshortener.presentation.dtos.user;

import luis.goes.urlshortener.presentation.dtos.DTO;

import java.util.UUID;

public record UserRequestDTO(
        String name,
        String email,
        String password,
        UUID roleId
) implements DTO {
}
package luis.goes.urlshortener.presentation.dtos.user;

import luis.goes.urlshortener.presentation.dtos.DTO;

import java.time.Instant;
import java.util.UUID;

public record UserResponseDto(
        UUID id,
        String name,
        String email,
        Instant createdAt,
        Instant updatedAt
) implements DTO {
}
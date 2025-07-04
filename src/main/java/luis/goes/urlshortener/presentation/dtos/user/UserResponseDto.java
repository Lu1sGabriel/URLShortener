package luis.goes.urlshortener.presentation.dtos.user;

import luis.goes.urlshortener.presentation.dtos.DTO;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record UserResponseDto(
        UUID id,
        String name,
        String email,
        String roleName,
        List<UserUrlDto> urls,
        Instant createdAt,
        Instant updatedAt
) implements DTO {
    public record UserUrlDto(
            String original,
            String shortened
    ) {
    }

}
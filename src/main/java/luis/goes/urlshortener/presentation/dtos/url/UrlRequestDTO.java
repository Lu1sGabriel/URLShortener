package luis.goes.urlshortener.presentation.dtos.url;

import luis.goes.urlshortener.presentation.dtos.DTO;

import java.util.UUID;

public record UrlRequestDTO(
        String urlName,
        String url,
        UUID userId
) implements DTO {
}
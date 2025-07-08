package luis.goes.urlshortener.modules.url.presentation.dto;

import luis.goes.urlshortener.core.shared.mapper.entityToDto.DTO;

import java.util.UUID;

public record UrlRequestDTO(
        String urlName,
        String url,
        UUID userId
) implements DTO {
}
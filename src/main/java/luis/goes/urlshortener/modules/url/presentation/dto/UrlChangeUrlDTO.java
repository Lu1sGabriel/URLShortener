package luis.goes.urlshortener.modules.url.presentation.dto;

import java.util.UUID;

public record UrlChangeUrlDTO(
        UUID id,
        UUID userId,
        String url
) {
}
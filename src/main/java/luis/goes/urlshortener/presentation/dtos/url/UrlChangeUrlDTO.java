package luis.goes.urlshortener.presentation.dtos.url;

import java.util.UUID;

public record UrlChangeUrlDTO(
        UUID id,
        UUID userId,
        String url
) {
}
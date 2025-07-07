package luis.goes.urlshortener.presentation.dtos.url;

import java.util.UUID;

public record UrlChangeUrlNameDTO(
        UUID id,
        UUID userId,
        String urlName
) {
}
package luis.goes.urlshortener.presentation.dtos.url;

import luis.goes.urlshortener.presentation.dtos.DTO;

import java.util.UUID;

public record UrlResponseDTO(
        UUID id,
        String urlName,
        String url,
        String shortened,
        UserInfo user
) implements DTO {
    public record UserInfo(
            UUID id,
            String name,
            String email1
    ) {
    }

}
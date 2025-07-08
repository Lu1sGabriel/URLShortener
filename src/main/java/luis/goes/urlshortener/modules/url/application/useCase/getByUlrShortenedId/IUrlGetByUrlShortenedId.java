package luis.goes.urlshortener.modules.url.application.useCase.getByUlrShortenedId;

import luis.goes.urlshortener.modules.url.presentation.dto.UrlResponseDTO;

public interface IUrlGetByUrlShortenedId {
    UrlResponseDTO get(String shortenedId);
}
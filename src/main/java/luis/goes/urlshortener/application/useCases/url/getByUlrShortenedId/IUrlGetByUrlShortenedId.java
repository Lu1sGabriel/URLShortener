package luis.goes.urlshortener.application.useCases.url.getByUlrShortenedId;

import luis.goes.urlshortener.presentation.dtos.url.UrlResponseDTO;

public interface IUrlGetByUrlShortenedId {
    UrlResponseDTO get(String shortenedId);
}
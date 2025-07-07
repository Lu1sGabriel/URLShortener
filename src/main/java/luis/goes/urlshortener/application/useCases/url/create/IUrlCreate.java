package luis.goes.urlshortener.application.useCases.url.create;

import luis.goes.urlshortener.presentation.dtos.url.UrlRequestDTO;
import luis.goes.urlshortener.presentation.dtos.url.UrlResponseDTO;

public interface IUrlCreate {
    UrlResponseDTO create(UrlRequestDTO dto);
}

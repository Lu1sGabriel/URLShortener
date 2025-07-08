package luis.goes.urlshortener.modules.url.application.useCase.create;

import luis.goes.urlshortener.modules.url.presentation.dto.UrlRequestDTO;
import luis.goes.urlshortener.modules.url.presentation.dto.UrlResponseDTO;

public interface IUrlCreate {
    UrlResponseDTO create(UrlRequestDTO dto);
}

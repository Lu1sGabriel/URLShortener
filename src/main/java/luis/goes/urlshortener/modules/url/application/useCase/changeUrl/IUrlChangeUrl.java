package luis.goes.urlshortener.modules.url.application.useCase.changeUrl;

import luis.goes.urlshortener.modules.url.presentation.dto.UrlChangeUrlDTO;
import luis.goes.urlshortener.modules.url.presentation.dto.UrlResponseDTO;

public interface IUrlChangeUrl {
    UrlResponseDTO change(UrlChangeUrlDTO dto);
}
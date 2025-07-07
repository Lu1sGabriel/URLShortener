package luis.goes.urlshortener.application.useCases.url.changeUrl;

import luis.goes.urlshortener.presentation.dtos.url.UrlChangeUrlDTO;
import luis.goes.urlshortener.presentation.dtos.url.UrlResponseDTO;

public interface IUrlChangeUrl {
    UrlResponseDTO change(UrlChangeUrlDTO dto);
}
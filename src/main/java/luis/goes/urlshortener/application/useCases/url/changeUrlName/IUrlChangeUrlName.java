package luis.goes.urlshortener.application.useCases.url.changeUrlName;

import luis.goes.urlshortener.presentation.dtos.url.UrlChangeUrlNameDTO;
import luis.goes.urlshortener.presentation.dtos.url.UrlResponseDTO;

public interface IUrlChangeUrlName {
    UrlResponseDTO change(UrlChangeUrlNameDTO dto);
}
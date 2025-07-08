package luis.goes.urlshortener.modules.url.application.useCase.changeUrlName;

import luis.goes.urlshortener.modules.url.presentation.dto.UrlChangeUrlNameDTO;
import luis.goes.urlshortener.modules.url.presentation.dto.UrlResponseDTO;

public interface IUrlChangeUrlName {
    UrlResponseDTO change(UrlChangeUrlNameDTO dto);
}
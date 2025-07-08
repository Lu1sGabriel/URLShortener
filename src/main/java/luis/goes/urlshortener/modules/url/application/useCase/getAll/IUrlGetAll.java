package luis.goes.urlshortener.modules.url.application.useCase.getAll;

import luis.goes.urlshortener.modules.url.presentation.dto.UrlResponseDTO;

import java.util.List;

public interface IUrlGetAll {
    List<UrlResponseDTO> get();
}
package luis.goes.urlshortener.application.useCases.url.getAll;

import luis.goes.urlshortener.presentation.dtos.url.UrlResponseDTO;

import java.util.List;

public interface IUrlGetAll {
    List<UrlResponseDTO> get();
}
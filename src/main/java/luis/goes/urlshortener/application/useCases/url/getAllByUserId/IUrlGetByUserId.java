package luis.goes.urlshortener.application.useCases.url.getAllByUserId;

import luis.goes.urlshortener.presentation.dtos.url.UrlResponseDTO;

import java.util.List;
import java.util.UUID;

public interface IUrlGetByUserId {
    List<UrlResponseDTO> get(UUID userId);
}
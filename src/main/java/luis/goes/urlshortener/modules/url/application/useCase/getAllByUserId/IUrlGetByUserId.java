package luis.goes.urlshortener.modules.url.application.useCase.getAllByUserId;

import luis.goes.urlshortener.modules.url.presentation.dto.UrlResponseDTO;

import java.util.List;
import java.util.UUID;

public interface IUrlGetByUserId {
    List<UrlResponseDTO> get(UUID userId);
}
package luis.goes.urlshortener.modules.url.application.useCase.gettersMethods;

import luis.goes.urlshortener.modules.url.presentation.dto.UrlResponseDTO;

import java.util.List;
import java.util.UUID;

public interface IUrlGetters {

    List<UrlResponseDTO> getAll();

    List<UrlResponseDTO> getByUser(UUID userId);

    UrlResponseDTO getByShortened(String userName, String shortenedId);

}
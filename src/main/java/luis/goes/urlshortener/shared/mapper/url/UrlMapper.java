package luis.goes.urlshortener.shared.mapper.url;

import luis.goes.urlshortener.domain.entity.url.URLEntity;
import luis.goes.urlshortener.presentation.dtos.url.UrlResponseDTO;
import luis.goes.urlshortener.shared.mapper.IMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UrlMapper implements IMapper<UrlResponseDTO, URLEntity> {

    @Override
    public UrlResponseDTO toDto(URLEntity urlEntity) {
        return new UrlResponseDTO(
                urlEntity.getId(),
                urlEntity.getUrlName().getValue(),
                urlEntity.getUrl().getValue(),
                urlEntity.getShortened(),
                new UrlResponseDTO.UserInfo(
                        urlEntity.getId(),
                        urlEntity.getUser().getName().getValue(),
                        urlEntity.getUser().getUserCredentials().getEmail().getValue())
        );
    }

    @Override
    public List<UrlResponseDTO> toDtoList(List<URLEntity> urlEntities) {
        return urlEntities.stream().map(this::toDto).toList();
    }

}
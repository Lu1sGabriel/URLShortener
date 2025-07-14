package luis.goes.urlshortener.modules.url.application.useCase.getByUlrShortenedId;

import luis.goes.urlshortener.core.exception.HttpException;
import luis.goes.urlshortener.modules.url.domain.URLEntity;
import luis.goes.urlshortener.modules.url.infrastructure.repository.UrlRepository;
import luis.goes.urlshortener.modules.url.presentation.dto.UrlResponseDTO;
import luis.goes.urlshortener.modules.url.shared.mapper.UrlMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlGetByUrlShortenedId implements IUrlGetByUrlShortenedId {
    private final UrlRepository repository;
    private final UrlMapper mapper;

    public UrlGetByUrlShortenedId(UrlRepository repository, UrlMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UrlResponseDTO get(String id) {
        List<URLEntity> urls = repository.findAll();

        URLEntity found = urls.stream()
                .filter(url -> {
                    String shortened = url.getShortened();
                    int idx = shortened.lastIndexOf("/");
                    String extractedId = (idx != -1) ? shortened.substring(idx + 1) : shortened;
                    return extractedId.equals(id);
                })
                .findFirst()
                .orElseThrow(() -> HttpException.notFound("We couldn't find a URL matching the provided shortened ID."));

        return mapper.toDto(found);
    }

}
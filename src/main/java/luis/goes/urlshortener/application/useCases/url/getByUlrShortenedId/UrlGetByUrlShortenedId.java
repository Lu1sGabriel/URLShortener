package luis.goes.urlshortener.application.useCases.url.getByUlrShortenedId;

import luis.goes.urlshortener.domain.entity.url.URLEntity;
import luis.goes.urlshortener.infrastructure.repository.url.UrlRepository;
import luis.goes.urlshortener.presentation.dtos.url.UrlResponseDTO;
import luis.goes.urlshortener.presentation.exception.HttpException;
import luis.goes.urlshortener.shared.mapper.url.UrlMapper;
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
                .findFirst().orElseThrow(() -> HttpException.notFound("URL not found with the given ID"));

        return mapper.toDto(found);
    }

}
package luis.goes.urlshortener.application.useCases.url.getAll;

import luis.goes.urlshortener.domain.entity.url.URLEntity;
import luis.goes.urlshortener.infrastructure.repository.url.UrlRepository;
import luis.goes.urlshortener.presentation.dtos.url.UrlResponseDTO;
import luis.goes.urlshortener.shared.mapper.url.UrlMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlGetAll implements IUrlGetAll {
    private final UrlRepository repository;
    private final UrlMapper mapper;

    public UrlGetAll(UrlRepository repository, UrlMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<UrlResponseDTO> get() {
        List<URLEntity> urls = repository.findAll();
        return mapper.toDtoList(urls);
    }

}
package luis.goes.urlshortener.modules.url.application.useCase.getAll;

import luis.goes.urlshortener.modules.url.domain.URLEntity;
import luis.goes.urlshortener.modules.url.infrastructure.repository.UrlRepository;
import luis.goes.urlshortener.modules.url.presentation.dto.UrlResponseDTO;
import luis.goes.urlshortener.modules.url.shared.mapper.UrlMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(readOnly = true)
    public List<UrlResponseDTO> get() {
        List<URLEntity> urls = repository.findAll();
        return mapper.toDtoList(urls);
    }

}
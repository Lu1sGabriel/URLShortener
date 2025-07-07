package luis.goes.urlshortener.application.useCases.url.delete;

import luis.goes.urlshortener.domain.entity.url.URLEntity;
import luis.goes.urlshortener.infrastructure.repository.url.UrlRepository;
import luis.goes.urlshortener.presentation.exception.HttpException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlDelete implements IUrlDelete {
    private final UrlRepository repository;

    public UrlDelete(UrlRepository repository) {
        this.repository = repository;
    }

    @Override
    public void delete(UUID id) {
        if (id == null) throw HttpException.badRequest("ID must not be null");
        URLEntity url = repository.findById(id).orElseThrow(() -> HttpException.notFound("Url not found with the given ID"));
        repository.delete(url);
    }

}
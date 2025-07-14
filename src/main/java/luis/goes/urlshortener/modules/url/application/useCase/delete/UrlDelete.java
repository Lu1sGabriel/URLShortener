package luis.goes.urlshortener.modules.url.application.useCase.delete;

import luis.goes.urlshortener.core.exception.HttpException;
import luis.goes.urlshortener.modules.url.domain.URLEntity;
import luis.goes.urlshortener.modules.url.infrastructure.repository.UrlRepository;
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
        if (id == null) throw HttpException.badRequest("An error occurred: ID was not provided.");

        URLEntity url = repository.findById(id)
                .orElseThrow(() -> HttpException.notFound("We couldn't find a URL with the provided ID."));

        repository.delete(url);
    }

}
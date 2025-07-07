package luis.goes.urlshortener.application.useCases.url.delete;

import java.util.UUID;

public interface IUrlDelete {
    void delete(UUID id);
}
package luis.goes.urlshortener.application.useCases.user.deactivate;

import java.util.UUID;

public interface IUserDeactivate {
    void deactivate(UUID id);
}
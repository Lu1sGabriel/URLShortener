package luis.goes.urlshortener.application.useCases.user.deactivate;

import java.util.UUID;

public interface IUserDeactivateUseCase {
    void deactivate(UUID id);
}

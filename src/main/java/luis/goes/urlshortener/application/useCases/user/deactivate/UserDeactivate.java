package luis.goes.urlshortener.application.useCases.user.deactivate;

import luis.goes.urlshortener.infrastructure.repository.user.UserRepository;
import luis.goes.urlshortener.presentation.exception.HttpException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserDeactivate implements IUserDeactivateUseCase {
    private final UserRepository repository;

    public UserDeactivate(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void deactivate(UUID id) {
        var user = repository.findById(id).orElseThrow(() -> HttpException.notFound("User not found."));
        user.dateInfo.deactivate();
        repository.save(user);
    }

}
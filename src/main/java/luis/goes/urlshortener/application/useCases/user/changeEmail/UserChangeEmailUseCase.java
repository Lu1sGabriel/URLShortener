package luis.goes.urlshortener.application.useCases.user.changeEmail;

import luis.goes.urlshortener.infrastructure.repository.user.UserRepository;
import luis.goes.urlshortener.shared.mapper.user.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserChangeEmailUseCase {
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserChangeEmailUseCase(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

}

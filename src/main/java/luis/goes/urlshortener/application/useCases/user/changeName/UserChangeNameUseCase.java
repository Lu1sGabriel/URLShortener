package luis.goes.urlshortener.application.useCases.user.changeName;

import luis.goes.urlshortener.infrastructure.repository.user.UserRepository;
import luis.goes.urlshortener.shared.mapper.user.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserChangeNameUseCase {
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserChangeNameUseCase(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

}
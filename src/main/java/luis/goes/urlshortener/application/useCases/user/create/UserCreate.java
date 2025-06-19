package luis.goes.urlshortener.application.useCases.user.create;

import luis.goes.urlshortener.domain.entity.user.UserEntity;
import luis.goes.urlshortener.infrastructure.repository.user.UserRepository;
import luis.goes.urlshortener.presentation.dtos.user.UserResponseDto;
import luis.goes.urlshortener.shared.mapper.user.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserCreate implements IUserCreateUseCase {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserCreate(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public final UserResponseDto create(String name, String email) {
        if (name == null) {
            return null;
        }

        UserEntity user = new UserEntity(name, email);

        repository.save(user);

        return mapper.toDto(repository.save(user));
    }

}
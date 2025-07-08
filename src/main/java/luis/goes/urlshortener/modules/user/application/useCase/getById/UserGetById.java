package luis.goes.urlshortener.modules.user.application.useCase.getById;

import luis.goes.urlshortener.modules.user.domain.UserEntity;
import luis.goes.urlshortener.modules.user.infrastructure.repository.UserRepository;
import luis.goes.urlshortener.modules.user.presentation.dto.UserResponseDto;
import luis.goes.urlshortener.core.exception.HttpException;
import luis.goes.urlshortener.modules.user.shared.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserGetById implements IUserGetById {
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserGetById(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserResponseDto get(UUID id) {
        UserEntity user = repository.findById(id).orElseThrow(() -> HttpException.notFound("User not found with the given ID"));
        return mapper.toDto(user);
    }

}
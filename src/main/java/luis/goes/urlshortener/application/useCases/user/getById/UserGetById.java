package luis.goes.urlshortener.application.useCases.user.getById;

import luis.goes.urlshortener.domain.entity.user.UserEntity;
import luis.goes.urlshortener.infrastructure.repository.user.UserRepository;
import luis.goes.urlshortener.presentation.dtos.user.UserResponseDto;
import luis.goes.urlshortener.presentation.exception.HttpException;
import luis.goes.urlshortener.shared.mapper.user.UserMapper;
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
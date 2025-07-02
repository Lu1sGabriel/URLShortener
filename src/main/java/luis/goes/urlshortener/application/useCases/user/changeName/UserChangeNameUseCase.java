package luis.goes.urlshortener.application.useCases.user.changeName;

import luis.goes.urlshortener.domain.entity.user.UserEntity;
import luis.goes.urlshortener.infrastructure.repository.user.UserRepository;
import luis.goes.urlshortener.presentation.dtos.user.UserChangeNameDTO;
import luis.goes.urlshortener.presentation.dtos.user.UserResponseDto;
import luis.goes.urlshortener.presentation.exception.HttpException;
import luis.goes.urlshortener.shared.mapper.user.UserMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserChangeNameUseCase implements IUserChangeNameUseCase {
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserChangeNameUseCase(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserResponseDto change(UUID id, UserChangeNameDTO dto) {
        if (id == null) throw HttpException.badRequest("ID must not be null");
        UserEntity user = repository.findById(id).orElseThrow(() -> HttpException.notFound("User not found with the giver ID."));
        user.changeName(dto.name());
        return mapper.toDto(repository.save(user));
    }

}
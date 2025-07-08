package luis.goes.urlshortener.modules.user.application.useCase.changeEmail;

import luis.goes.urlshortener.modules.user.domain.UserEntity;
import luis.goes.urlshortener.modules.user.infrastructure.repository.UserRepository;
import luis.goes.urlshortener.modules.user.presentation.dto.UserChangeEmailDTO;
import luis.goes.urlshortener.modules.user.presentation.dto.UserResponseDto;
import luis.goes.urlshortener.core.exception.HttpException;
import luis.goes.urlshortener.modules.user.shared.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserChangeEmail implements IUserChangeEmail {
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserChangeEmail(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserResponseDto change(UUID id, UserChangeEmailDTO dto) {
        if (id == null) throw HttpException.badRequest("ID must not be null.");
        UserEntity user = repository.findById(id).orElseThrow(() -> HttpException.notFound("User not found with the given ID."));
        user.changeEmail(dto.email());
        return mapper.toDto(repository.save(user));
    }

}
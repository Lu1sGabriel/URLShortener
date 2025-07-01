package luis.goes.urlshortener.application.useCases.user.changePassword;

import luis.goes.urlshortener.domain.entity.user.UserEntity;
import luis.goes.urlshortener.infrastructure.repository.user.UserRepository;
import luis.goes.urlshortener.presentation.dtos.user.UserChangePasswordDTO;
import luis.goes.urlshortener.presentation.dtos.user.UserResponseDto;
import luis.goes.urlshortener.presentation.exception.HttpException;
import luis.goes.urlshortener.shared.mapper.user.UserMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserChangePasswordUseCase implements IUserChangePasswordUseCase {
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserChangePasswordUseCase(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserResponseDto change(UUID id, UserChangePasswordDTO dto) {
        if (id == null) throw HttpException.badRequest("ID must not be null");
        if (!dto.password().equals(dto.confirmPassword())) throw HttpException.badRequest("Password and confirm password do not match.");
        UserEntity user = repository.findById(id).orElseThrow(() -> HttpException.notFound("User not found with ID"));
        user.changeUserPassword(dto.password());
        var changed = repository.save(user);
        return mapper.toDto(changed);
    }

}

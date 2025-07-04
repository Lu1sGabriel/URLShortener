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
public class UserChangePassword implements IUserChangePassword {
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserChangePassword(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserResponseDto change(UUID id, UserChangePasswordDTO dto) {
        if (id == null) throw HttpException.badRequest("ID must not be null");
        UserEntity user = repository.findById(id).orElseThrow(() -> HttpException.notFound("User not found with ID"));
        user.isPasswordMatches(user.getUserCredentials().getPassword().getValue(), dto.currentPassword());
        user.changePassword(dto.password(), dto.confirmPassword());
        var changed = repository.save(user);
        return mapper.toDto(changed);
    }

}

package luis.goes.urlshortener.application.useCases.user.login;

import luis.goes.urlshortener.domain.entity.user.UserEntity;
import luis.goes.urlshortener.domain.valueObjects.Email;
import luis.goes.urlshortener.infrastructure.repository.user.UserRepository;
import luis.goes.urlshortener.presentation.dtos.user.UserLoginDTO;
import luis.goes.urlshortener.presentation.dtos.user.UserResponseDto;
import luis.goes.urlshortener.presentation.exception.HttpException;
import luis.goes.urlshortener.shared.mapper.user.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserLoginUseCase implements IUserLoginUseCase {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserLoginUseCase(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserResponseDto login(UserLoginDTO dto) {
        final Email email = new Email(dto.email());
        UserEntity user = repository.findByUserCredentials_Email(email).orElseThrow(() -> HttpException.notFound("User not found with the given email."));
        user.isPasswordMatches(user.getUserCredentials().getPassword().getValue(), dto.password());

        return mapper.toDto(user);
    }

}
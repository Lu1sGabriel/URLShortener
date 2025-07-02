package luis.goes.urlshortener.application.useCases.user.login;

import luis.goes.urlshortener.presentation.dtos.user.UserLoginDTO;
import luis.goes.urlshortener.presentation.dtos.user.UserResponseDto;

import java.util.UUID;

public interface IUserLoginUseCase {
    UserResponseDto login(UserLoginDTO dto);
}

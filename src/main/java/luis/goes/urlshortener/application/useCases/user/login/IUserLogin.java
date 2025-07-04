package luis.goes.urlshortener.application.useCases.user.login;

import luis.goes.urlshortener.presentation.dtos.user.UserLoginDTO;
import luis.goes.urlshortener.presentation.dtos.user.UserResponseDto;

public interface IUserLogin {
    UserResponseDto login(UserLoginDTO dto);
}

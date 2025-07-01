package luis.goes.urlshortener.application.useCases.user.changePassword;

import luis.goes.urlshortener.presentation.dtos.user.UserChangePasswordDTO;
import luis.goes.urlshortener.presentation.dtos.user.UserResponseDto;

import java.util.UUID;

public interface IUserChangePasswordUseCase {

    UserResponseDto change(UUID id, UserChangePasswordDTO dto);

}
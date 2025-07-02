package luis.goes.urlshortener.application.useCases.user.changeEmail;

import luis.goes.urlshortener.presentation.dtos.user.UserChangeEmailDTO;
import luis.goes.urlshortener.presentation.dtos.user.UserResponseDto;

import java.util.UUID;

public interface IUserChangeEmailUseCase {

    UserResponseDto change(UUID id, UserChangeEmailDTO dto);

}
package luis.goes.urlshortener.application.useCases.user.changeName;

import luis.goes.urlshortener.presentation.dtos.user.UserChangeNameDTO;
import luis.goes.urlshortener.presentation.dtos.user.UserResponseDto;

import java.util.UUID;

public interface IUserChangeNameUseCase {

    UserResponseDto change(UUID id, UserChangeNameDTO dto);
}

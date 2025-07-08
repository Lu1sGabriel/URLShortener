package luis.goes.urlshortener.modules.user.application.useCase.getById;

import luis.goes.urlshortener.modules.user.presentation.dto.UserResponseDto;

import java.util.UUID;

public interface IUserGetById {
    UserResponseDto get(UUID id);
}
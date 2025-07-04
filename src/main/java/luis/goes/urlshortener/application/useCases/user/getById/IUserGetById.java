package luis.goes.urlshortener.application.useCases.user.getById;

import luis.goes.urlshortener.presentation.dtos.user.UserResponseDto;

import java.util.UUID;

public interface IUserGetById {
    UserResponseDto get(UUID id);
}
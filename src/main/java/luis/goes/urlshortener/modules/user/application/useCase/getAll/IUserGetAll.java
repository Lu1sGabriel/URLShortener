package luis.goes.urlshortener.modules.user.application.useCase.getAll;

import luis.goes.urlshortener.modules.user.presentation.dto.UserResponseDto;

import java.util.List;

public interface IUserGetAll {
    List<UserResponseDto> get();
}
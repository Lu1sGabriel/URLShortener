package luis.goes.urlshortener.application.useCases.user.getAll;

import luis.goes.urlshortener.presentation.dtos.user.UserResponseDto;

import java.util.List;

public interface IUserGetAll {
    List<UserResponseDto> get();
}
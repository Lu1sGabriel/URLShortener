package luis.goes.urlshortener.application.useCases.user.create;

import luis.goes.urlshortener.presentation.dtos.user.UserResponseDto;

public interface IUserCreateUseCase {

    UserResponseDto create(String name, String email);

}
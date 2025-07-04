package luis.goes.urlshortener.application.useCases.user.create;

import luis.goes.urlshortener.presentation.dtos.user.UserRequestDTO;
import luis.goes.urlshortener.presentation.dtos.user.UserResponseDto;

public interface IUserCreate {

    UserResponseDto create(UserRequestDTO dto);

}
package luis.goes.urlshortener.modules.login.application.useCases.login;

import luis.goes.urlshortener.modules.login.presentation.dto.LoginRequestDTO;
import luis.goes.urlshortener.modules.login.presentation.dto.LoginResponseDTO;

public interface ILogin {
    LoginResponseDTO login(LoginRequestDTO dto);
}

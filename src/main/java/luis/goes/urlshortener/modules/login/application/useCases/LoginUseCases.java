package luis.goes.urlshortener.modules.login.application.useCases;

import lombok.Getter;
import luis.goes.urlshortener.modules.login.application.useCases.login.Login;
import org.springframework.stereotype.Component;

@Component
@Getter
public class LoginUseCases {
    private final Login login;

    public LoginUseCases(Login login) {
        this.login = login;
    }

}

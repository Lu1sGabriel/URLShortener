package luis.goes.urlshortener.infrastructure.configuration;

import jakarta.annotation.PostConstruct;
import luis.goes.urlshortener.domain.valueObject.Password;
import luis.goes.urlshortener.shared.helpers.password.PasswordHashMapper;
import org.springframework.stereotype.Component;

@Component
public class PasswordBootstrap {

    private final PasswordHashMapper passwordHashMapper;

    public PasswordBootstrap(PasswordHashMapper passwordHashMapper) {
        this.passwordHashMapper = passwordHashMapper;
    }

    @PostConstruct
    public void init() {
        Password.injectHasher(passwordHashMapper);
    }

}
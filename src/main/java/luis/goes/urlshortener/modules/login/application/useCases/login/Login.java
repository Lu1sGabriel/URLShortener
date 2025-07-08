package luis.goes.urlshortener.modules.login.application.useCases.login;

import luis.goes.urlshortener.core.exception.HttpException;
import luis.goes.urlshortener.core.infrastructure.security.AuthenticationService;
import luis.goes.urlshortener.core.infrastructure.security.UserAuthenticated;
import luis.goes.urlshortener.modules.login.presentation.dto.LoginRequestDTO;
import luis.goes.urlshortener.modules.login.presentation.dto.LoginResponseDTO;
import luis.goes.urlshortener.modules.user.domain.UserEntity;
import luis.goes.urlshortener.modules.user.infrastructure.repository.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class Login implements ILogin {

    private final UserRepository repository;
    private final AuthenticationService authenticationService;

    public Login(UserRepository repository, AuthenticationService authenticationService) {
        this.repository = repository;
        this.authenticationService = authenticationService;
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO dto) {
        UserEntity user = repository
                .findByUserCredentials_Email_Email(dto.email())
                .orElseThrow(() -> HttpException.notFound("User not found."));
        if (user.getDateInfo().getDeletedAt() != null) throw HttpException.badRequest("This user is deactivated. Please contact us to enable it again.");
        user.isPasswordMatches(user.getUserCredentials().getPassword().getValue(), dto.password());

        UserDetails userDetails = new UserAuthenticated(user);
        String token = authenticationService.authenticate(new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()));

        return new LoginResponseDTO(token);
    }

}
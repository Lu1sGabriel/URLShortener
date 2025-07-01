package luis.goes.urlshortener.presentation.dtos.user;

public record UserChangePasswordDTO(
        String password,
        String confirmPassword
) {
}
package luis.goes.urlshortener.presentation.dtos.user;

public record UserChangePasswordDTO(
        String currentPassword,
        String password,
        String confirmPassword
) {
}
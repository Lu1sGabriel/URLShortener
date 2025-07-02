package luis.goes.urlshortener.presentation.dtos.user;

public record UserLoginDTO(
        String email,
        String password
) {
    public UserLoginDTO {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email não pode ser nulo ou em branco.");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Senha não pode ser nula ou em branco.");
        }
    }
}

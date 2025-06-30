package luis.goes.urlshortener.presentation.dtos.user;

import luis.goes.urlshortener.presentation.dtos.DTO;

public record UserRequestDTO(String name, String email, String password) implements DTO {
}
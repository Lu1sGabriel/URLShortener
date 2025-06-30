package luis.goes.urlshortener.presentation.controllers.user;

import luis.goes.urlshortener.application.useCases.user.UserUseCases;
import luis.goes.urlshortener.presentation.dtos.user.UserRequestDTO;
import luis.goes.urlshortener.presentation.dtos.user.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    private final UserUseCases userUseCases;

    public UserController(UserUseCases userUseCases) {
        this.userUseCases = userUseCases;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDTO dto) {
        return ResponseEntity.ok().body(userUseCases.getUserCreateUseCase().create(dto.name(), dto.email(), dto.password()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deactivate(@PathVariable UUID id) {
        userUseCases.getUserDeactivateUseCase().deactivate(id);
        return ResponseEntity.noContent().build();
    }

}
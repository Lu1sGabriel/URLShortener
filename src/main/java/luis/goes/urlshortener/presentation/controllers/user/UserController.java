package luis.goes.urlshortener.presentation.controllers.user;

import luis.goes.urlshortener.application.useCases.user.create.IUserCreateUseCase;
import luis.goes.urlshortener.application.useCases.user.deactivate.IUserDeactivateUseCase;
import luis.goes.urlshortener.presentation.dtos.user.UserRequestDTO;
import luis.goes.urlshortener.presentation.dtos.user.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    private final IUserCreateUseCase userCreateUseCase;
    private final IUserDeactivateUseCase userDeactivateUseCase;

    public UserController(IUserCreateUseCase userCreateUseCase, IUserDeactivateUseCase userDeactivateUseCase) {
        this.userCreateUseCase = userCreateUseCase;
        this.userDeactivateUseCase = userDeactivateUseCase;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDTO dto) {
        return ResponseEntity.ok().body(userCreateUseCase.create(dto.name()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deactivate(@PathVariable UUID id) {
        userDeactivateUseCase.deactivate(id);
        return ResponseEntity.noContent().build();
    }

}
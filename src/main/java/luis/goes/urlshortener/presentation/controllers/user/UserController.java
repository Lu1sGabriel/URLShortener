package luis.goes.urlshortener.presentation.controllers.user;

import luis.goes.urlshortener.application.useCases.user.UserUseCases;
import luis.goes.urlshortener.presentation.dtos.user.*;
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

    @PostMapping(value = "/login")
    public ResponseEntity<UserResponseDto> login(@RequestBody UserLoginDTO dto) {
        return ResponseEntity.ok().body(userUseCases.getUserLoginUseCase().login(dto));
    }

    @PatchMapping(value = "/password/{id}")
    public ResponseEntity<UserResponseDto> changePassword(@PathVariable UUID id, @RequestBody UserChangePasswordDTO dto) {
        return ResponseEntity.ok().body(userUseCases.getUserChangePasswordUseCase().change(id, dto));
    }

    @PatchMapping(value = "/name/{id}")
    public ResponseEntity<UserResponseDto> changeName(@PathVariable UUID id, @RequestBody UserChangeNameDTO dto) {
        return ResponseEntity.ok().body(userUseCases.getUserChangeNameUseCase().change(id, dto));
    }

    @PatchMapping(value = "/email/{id}")
    public ResponseEntity<UserResponseDto> changeEmail(@PathVariable UUID id, @RequestBody UserChangeEmailDTO dto) {
        return ResponseEntity.ok().body(userUseCases.getUserChangeEmailUseCase().change(id, dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deactivate(@PathVariable UUID id) {
        userUseCases.getUserDeactivateUseCase().deactivate(id);
        return ResponseEntity.noContent().build();
    }

}
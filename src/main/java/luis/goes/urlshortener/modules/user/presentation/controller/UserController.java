package luis.goes.urlshortener.modules.user.presentation.controller;

import luis.goes.urlshortener.modules.user.application.useCase.UserUseCases;
import luis.goes.urlshortener.modules.user.presentation.dto.*;
import luis.goes.urlshortener.core.shared.utils.JwtUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    private final UserUseCases userUseCases;

    public UserController(UserUseCases userUseCases) {
        this.userUseCases = userUseCases;
    }

    @GetMapping(value = "/me")
    public ResponseEntity<UserResponseDto> getById() {
        UUID id = JwtUtils.getCurrentUserId();
        return ResponseEntity.ok(userUseCases.getById().get(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAll() {
        return ResponseEntity.ok(userUseCases.getAll().get());
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDTO dto) {
        return ResponseEntity.ok(userUseCases.getCreate().create(dto));
    }

    @PatchMapping(value = "/password/{id}")
    public ResponseEntity<UserResponseDto> changePassword(@PathVariable UUID id, @RequestBody UserChangePasswordDTO dto) {
        return ResponseEntity.ok(userUseCases.getChangePassword().change(id, dto));
    }

    @PatchMapping(value = "/name/{id}")
    public ResponseEntity<UserResponseDto> changeName(@PathVariable UUID id, @RequestBody UserChangeNameDTO dto) {
        return ResponseEntity.ok(userUseCases.getChangeName().change(id, dto));
    }

    @PatchMapping(value = "/email/{id}")
    public ResponseEntity<UserResponseDto> changeEmail(@PathVariable UUID id, @RequestBody UserChangeEmailDTO dto) {
        return ResponseEntity.ok(userUseCases.getChangeEmail().change(id, dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deactivate(@PathVariable UUID id) {
        userUseCases.getDeactivate().deactivate(id);
        return ResponseEntity.noContent().build();
    }

}
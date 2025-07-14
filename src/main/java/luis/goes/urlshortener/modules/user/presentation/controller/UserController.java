package luis.goes.urlshortener.modules.user.presentation.controller;

import luis.goes.urlshortener.core.shared.utils.JwtUtils;
import luis.goes.urlshortener.modules.user.application.useCase.UserUseCases;
import luis.goes.urlshortener.modules.user.presentation.dto.*;
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
        return ResponseEntity.ok(userUseCases.getGetters().byId(getUserIdByJwt()));
    }

    @GetMapping(value = "/all/deactivated")
    public ResponseEntity<List<UserResponseDto>> getAllDeactivated() {
        return ResponseEntity.ok(userUseCases.getGetters().allDeactivated());
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<UserResponseDto> getByName(@PathVariable String name) {
        return ResponseEntity.ok(userUseCases.getGetters().byName(name));
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<UserResponseDto> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userUseCases.getGetters().byEmail(email));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAll() {
        return ResponseEntity.ok(userUseCases.getGetters().all());
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDTO dto) {
        return ResponseEntity.ok(userUseCases.getCreate().create(dto));
    }

    @PatchMapping(value = "/password")
    public ResponseEntity<UserResponseDto> changePassword(@RequestBody UserChangePasswordDTO dto) {
        return ResponseEntity.ok(userUseCases.getChangePassword().change(getUserIdByJwt(), dto));
    }

    @PatchMapping(value = "/name")
    public ResponseEntity<UserResponseDto> changeName(@RequestBody UserChangeNameDTO dto) {
        return ResponseEntity.ok(userUseCases.getChangeName().change(getUserIdByJwt(), dto));
    }

    @PatchMapping(value = "/email")
    public ResponseEntity<UserResponseDto> changeEmail(@RequestBody UserChangeEmailDTO dto) {
        return ResponseEntity.ok(userUseCases.getChangeEmail().change(getUserIdByJwt(), dto));
    }

    @DeleteMapping
    public ResponseEntity<Void> deactivate() {
        userUseCases.getDeactivate().deactivate(getUserIdByJwt());
        return ResponseEntity.noContent().build();
    }

    private UUID getUserIdByJwt() {
        return JwtUtils.getCurrentUserId();
    }

}
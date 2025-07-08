package luis.goes.urlshortener.modules.login.presentation.controller;

import luis.goes.urlshortener.modules.login.application.useCases.LoginUseCases;
import luis.goes.urlshortener.modules.login.presentation.dto.LoginRequestDTO;
import luis.goes.urlshortener.modules.login.presentation.dto.LoginResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final LoginUseCases useCases;

    public LoginController(LoginUseCases useCases) {
        this.useCases = useCases;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO dto) {
        return ResponseEntity.ok(useCases.getLogin().login(dto));
    }

}
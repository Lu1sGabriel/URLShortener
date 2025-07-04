package luis.goes.urlshortener.presentation.controllers.role;

import luis.goes.urlshortener.application.useCases.role.RoleUseCases;
import luis.goes.urlshortener.presentation.dtos.role.RoleRequestDTO;
import luis.goes.urlshortener.presentation.dtos.role.RoleResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/role")
public class RoleController {

    private final RoleUseCases useCases;

    public RoleController(RoleUseCases useCases) {
        this.useCases = useCases;
    }

    @GetMapping
    public ResponseEntity<List<RoleResponseDTO>> getAll() {
        return ResponseEntity.ok().body(useCases.getAll().get());
    }

    @PostMapping
    public ResponseEntity<RoleResponseDTO> create(@RequestBody RoleRequestDTO dto) {
        return ResponseEntity.ok().body(useCases.getCreate().create(dto));
    }

}
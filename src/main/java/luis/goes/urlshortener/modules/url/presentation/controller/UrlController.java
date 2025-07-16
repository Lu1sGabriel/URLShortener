package luis.goes.urlshortener.modules.url.presentation.controller;

import luis.goes.urlshortener.core.shared.utils.JwtUtils;
import luis.goes.urlshortener.modules.url.application.useCase.UrlUseCases;
import luis.goes.urlshortener.modules.url.presentation.dto.UrlChangeUrlDTO;
import luis.goes.urlshortener.modules.url.presentation.dto.UrlChangeUrlNameDTO;
import luis.goes.urlshortener.modules.url.presentation.dto.UrlRequestDTO;
import luis.goes.urlshortener.modules.url.presentation.dto.UrlResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/url")
public class UrlController {

    private final UrlUseCases useCases;

    public UrlController(UrlUseCases useCases) {
        this.useCases = useCases;
    }

    @GetMapping
    public ResponseEntity<List<UrlResponseDTO>> getAll() {
        return ResponseEntity.ok(useCases.getGetters().getAll());
    }

    @GetMapping(value = "/user")
    public ResponseEntity<List<UrlResponseDTO>> getByUserId() {
        return ResponseEntity.ok(useCases.getGetters().getByUser(JwtUtils.getSubject()));
    }

    @PostMapping
    public ResponseEntity<UrlResponseDTO> create(@RequestBody UrlRequestDTO dto) {
        return ResponseEntity.ok(useCases.getCreate().create(dto));
    }

    @PatchMapping(value = "/change/url-name")
    public ResponseEntity<UrlResponseDTO> changeUrlName(@RequestBody UrlChangeUrlNameDTO dto) {
        return ResponseEntity.ok(useCases.getChangeUrlName().change(dto));
    }

    @PatchMapping(value = "/change/url")
    public ResponseEntity<UrlResponseDTO> changeUrl(@RequestBody UrlChangeUrlDTO dto) {
        return ResponseEntity.ok(useCases.getChangeUrl().change(dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        useCases.getDelete().delete(id);
        return ResponseEntity.noContent().build();
    }

}
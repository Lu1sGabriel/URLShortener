package luis.goes.urlshortener.presentation.controllers.url;

import luis.goes.urlshortener.application.useCases.url.UrlUseCases;
import luis.goes.urlshortener.presentation.dtos.url.UrlChangeUrlDTO;
import luis.goes.urlshortener.presentation.dtos.url.UrlChangeUrlNameDTO;
import luis.goes.urlshortener.presentation.dtos.url.UrlRequestDTO;
import luis.goes.urlshortener.presentation.dtos.url.UrlResponseDTO;
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
        return ResponseEntity.ok(useCases.getAll().get());
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<List<UrlResponseDTO>> getByUserId(@PathVariable UUID id) {
        return ResponseEntity.ok(useCases.getByUserId().get(id));
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
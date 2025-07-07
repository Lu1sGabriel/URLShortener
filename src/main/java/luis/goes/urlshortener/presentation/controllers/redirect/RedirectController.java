package luis.goes.urlshortener.presentation.controllers.redirect;

import luis.goes.urlshortener.application.useCases.url.UrlUseCases;
import luis.goes.urlshortener.presentation.dtos.url.UrlResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class RedirectController {

    private final UrlUseCases useCases;

    public RedirectController(UrlUseCases useCases) {
        this.useCases = useCases;
    }

    @GetMapping("/{shortened}")
    public ResponseEntity<Void> redirectToOriginal(@PathVariable String shortened) {
        UrlResponseDTO urlResponseDTO = useCases.getByUrlShortenedId().get(shortened);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(urlResponseDTO.url()));
        return new ResponseEntity<>(headers, HttpStatus.FOUND); // 302 Redirect
    }
}

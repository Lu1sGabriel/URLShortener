package luis.goes.urlshortener.application.useCases.url.changeUrl;

import luis.goes.urlshortener.infrastructure.repository.url.UrlRepository;
import luis.goes.urlshortener.infrastructure.repository.user.UserRepository;
import luis.goes.urlshortener.presentation.dtos.url.UrlChangeUrlDTO;
import luis.goes.urlshortener.presentation.dtos.url.UrlResponseDTO;
import luis.goes.urlshortener.presentation.exception.HttpException;
import luis.goes.urlshortener.shared.mapper.url.UrlMapper;
import org.springframework.stereotype.Service;

@Service
public class UrlChangeUrl implements IUrlChangeUrl {
    private final UrlRepository repository;
    private final UserRepository userRepository;
    private final UrlMapper mapper;

    public UrlChangeUrl(UrlRepository repository, UserRepository userRepository, UrlMapper mapper) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public UrlResponseDTO change(UrlChangeUrlDTO dto) {
        var user = userRepository.findById(dto.userId())
                .orElseThrow(() -> HttpException.notFound("User not found with the given ID."));

        var url = repository.findById(dto.id())
                .orElseThrow(() -> HttpException.notFound("URL not found with the given ID."));

        if (url.getUser().getId() != user.getId()) throw HttpException.badRequest("The user ID is not the same as the URL");

        url.changeOriginalUrl(dto.url());

        return mapper.toDto(repository.save(url));
    }

}
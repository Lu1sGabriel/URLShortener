package luis.goes.urlshortener.application.useCases.url.create;

import luis.goes.urlshortener.domain.entity.url.URLEntity;
import luis.goes.urlshortener.infrastructure.repository.url.UrlRepository;
import luis.goes.urlshortener.infrastructure.repository.user.UserRepository;
import luis.goes.urlshortener.presentation.dtos.url.UrlRequestDTO;
import luis.goes.urlshortener.presentation.dtos.url.UrlResponseDTO;
import luis.goes.urlshortener.presentation.exception.HttpException;
import luis.goes.urlshortener.shared.mapper.url.UrlMapper;
import luis.goes.urlshortener.shared.utils.NameFormatter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlCreate implements IUrlCreate {

    private final UrlRepository repository;
    private final UserRepository userRepository;
    private final UrlMapper mapper;

    public UrlCreate(UrlRepository repository, UserRepository userRepository, UrlMapper mapper) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public UrlResponseDTO create(UrlRequestDTO dto) {
        var user = userRepository.findById(dto.userId())
                .orElseThrow(() -> HttpException.notFound("User not found with the given ID."));

        UUID id;
        do {
            id = UUID.randomUUID();
        } while (idPrefixExists(id));

        String userName = getFirstAndLastUserName(user.getName().getValue().split(" "));
        String idPrefix = extractIdPrefix(id);
        String shortenedUrl = buildShortenedUrl(userName, idPrefix);

        URLEntity url = new URLEntity(dto.urlName(), dto.url(), shortenedUrl, user);
        return mapper.toDto(repository.save(url));
    }

    private boolean idPrefixExists(UUID uuid) {
        String prefix = extractIdPrefix(uuid);

        return repository.findAll().stream()
                .map(url -> {
                    String shortened = url.getShortened();
                    int idx = shortened.lastIndexOf("/");
                    return (idx != -1) ? shortened.substring(idx + 1) : shortened;
                })
                .anyMatch(idPart -> idPart.startsWith(prefix));
    }

    private String extractIdPrefix(UUID uuid) {
        return uuid.toString().split("-")[0];
    }

    private String getFirstAndLastUserName(String[] splittedName) {
        int length = splittedName.length;
        String firstName = NameFormatter.removeAccents(splittedName[0]).toLowerCase();
        String lastName = NameFormatter.removeAccents(splittedName[length - 1]).toLowerCase();

        return NameFormatter.removeAccents(firstName).toLowerCase() + "-" + NameFormatter.removeAccents(lastName).toLowerCase();
    }

    private String buildShortenedUrl(String userName, String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID não pode ser nulo ou vazio");
        }
        return String.format("%s/%s", userName, id);
    }

}
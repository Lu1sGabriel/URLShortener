package luis.goes.urlshortener.modules.url.application.useCase.getAllByUserId;

import luis.goes.urlshortener.modules.url.domain.URLEntity;
import luis.goes.urlshortener.modules.user.domain.UserEntity;
import luis.goes.urlshortener.modules.url.infrastructure.repository.UrlRepository;
import luis.goes.urlshortener.modules.user.infrastructure.repository.UserRepository;
import luis.goes.urlshortener.modules.url.presentation.dto.UrlResponseDTO;
import luis.goes.urlshortener.core.exception.HttpException;
import luis.goes.urlshortener.modules.url.shared.mapper.UrlMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UrlGetByUserId implements IUrlGetByUserId {
    private final UrlRepository repository;
    private final UserRepository userRepository;
    private final UrlMapper mapper;

    public UrlGetByUserId(UrlRepository repository, UserRepository userRepository, UrlMapper mapper) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public List<UrlResponseDTO> get(UUID userId) {
        if (userId == null) throw HttpException.badRequest("ID must not be null");
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> HttpException.notFound("User not found with the given ID."));
        List<URLEntity> urls = repository.findAllByUser_Id(user.getId());
        return mapper.toDtoList(urls);
    }

}
package luis.goes.urlshortener.modules.user.application.useCase.getAll;

import luis.goes.urlshortener.modules.user.domain.UserEntity;
import luis.goes.urlshortener.modules.user.infrastructure.repository.UserRepository;
import luis.goes.urlshortener.modules.user.presentation.dto.UserResponseDto;
import luis.goes.urlshortener.modules.user.shared.mapper.UserMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGetAll implements IUserGetAll {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserGetAll(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<UserResponseDto> get() {
        List<UserEntity> users = repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return mapper.toDtoList(users);
    }

}

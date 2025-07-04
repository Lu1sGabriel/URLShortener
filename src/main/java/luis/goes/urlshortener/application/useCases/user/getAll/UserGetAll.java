package luis.goes.urlshortener.application.useCases.user.getAll;

import luis.goes.urlshortener.domain.entity.user.UserEntity;
import luis.goes.urlshortener.infrastructure.repository.user.UserRepository;
import luis.goes.urlshortener.presentation.dtos.user.UserResponseDto;
import luis.goes.urlshortener.shared.mapper.user.UserMapper;
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

package luis.goes.urlshortener.application.useCases.user.create;

import luis.goes.urlshortener.application.useCases.role.getById.IRoleGetById;
import luis.goes.urlshortener.domain.entity.role.RoleEntity;
import luis.goes.urlshortener.domain.entity.user.UserEntity;
import luis.goes.urlshortener.infrastructure.repository.user.UserRepository;
import luis.goes.urlshortener.presentation.dtos.user.UserRequestDTO;
import luis.goes.urlshortener.presentation.dtos.user.UserResponseDto;
import luis.goes.urlshortener.shared.mapper.user.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserCreate implements IUserCreate {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final IRoleGetById getById;

    public UserCreate(UserRepository repository, UserMapper mapper, IRoleGetById getById) {
        this.repository = repository;
        this.mapper = mapper;
        this.getById = getById;
    }

    @Override
    public final UserResponseDto create(UserRequestDTO dto) {
        RoleEntity role = getById.get(dto.roleId());
        UserEntity user = new UserEntity(dto.name(), dto.email(), dto.password(), role);

        return mapper.toDto(repository.save(user));
    }

}
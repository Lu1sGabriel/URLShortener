package luis.goes.urlshortener.application.useCases.user.create;

import luis.goes.urlshortener.domain.entity.role.RoleEntity;
import luis.goes.urlshortener.domain.entity.user.UserEntity;
import luis.goes.urlshortener.infrastructure.repository.role.RoleRepository;
import luis.goes.urlshortener.infrastructure.repository.user.UserRepository;
import luis.goes.urlshortener.presentation.dtos.user.UserRequestDTO;
import luis.goes.urlshortener.presentation.dtos.user.UserResponseDto;
import luis.goes.urlshortener.presentation.exception.HttpException;
import luis.goes.urlshortener.shared.mapper.user.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserCreate implements IUserCreate {

    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final UserMapper mapper;

    public UserCreate(UserRepository repository, RoleRepository roleRepository, UserMapper mapper) {
        this.repository = repository;
        this.roleRepository = roleRepository;
        this.mapper = mapper;
    }

    @Override
    public final UserResponseDto create(UserRequestDTO dto) {
        RoleEntity role = roleRepository.findById(dto.roleId()).orElseThrow(() -> HttpException.notFound("Role not found with the given ID."));
        UserEntity user = new UserEntity(dto.name(), dto.email(), dto.password(), role);

        return mapper.toDto(repository.save(user));
    }

}
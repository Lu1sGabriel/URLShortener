package luis.goes.urlshortener.application.useCases.role.create;

import luis.goes.urlshortener.domain.entity.role.RoleEntity;
import luis.goes.urlshortener.infrastructure.repository.role.RoleRepository;
import luis.goes.urlshortener.presentation.dtos.role.RoleRequestDTO;
import luis.goes.urlshortener.presentation.dtos.role.RoleResponseDTO;
import luis.goes.urlshortener.shared.mapper.role.RoleMapper;
import org.springframework.stereotype.Service;

@Service
public class RoleCreate implements IRoleCreate {
    private final RoleRepository repository;
    private final RoleMapper roleMapper;

    public RoleCreate(RoleRepository repository, RoleMapper roleMapper) {
        this.repository = repository;
        this.roleMapper = roleMapper;
    }

    @Override
    public RoleResponseDTO create(RoleRequestDTO dto) {
        RoleEntity roleEntity = new RoleEntity(dto.name(), dto.description());
        return roleMapper.toDto(repository.save(roleEntity));
    }

}
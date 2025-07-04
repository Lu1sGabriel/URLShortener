package luis.goes.urlshortener.application.useCases.role.getAll;

import luis.goes.urlshortener.infrastructure.repository.role.RoleRepository;
import luis.goes.urlshortener.presentation.dtos.role.RoleResponseDTO;
import luis.goes.urlshortener.shared.mapper.role.RoleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleGetAll implements IRoleGetAll {
    private final RoleRepository repository;
    private final RoleMapper mapper;

    public RoleGetAll(RoleRepository repository, RoleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<RoleResponseDTO> get() {
        return mapper.toDtoList(repository.findAll());
    }

}
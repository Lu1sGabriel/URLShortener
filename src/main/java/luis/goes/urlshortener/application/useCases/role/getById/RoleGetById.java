package luis.goes.urlshortener.application.useCases.role.getById;

import luis.goes.urlshortener.domain.entity.role.RoleEntity;
import luis.goes.urlshortener.infrastructure.repository.role.RoleRepository;
import luis.goes.urlshortener.presentation.exception.HttpException;
import luis.goes.urlshortener.shared.mapper.role.RoleMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoleGetById implements IRoleGetById {
    private final RoleRepository repository;

    public RoleGetById(RoleRepository repository, RoleMapper mapper) {
        this.repository = repository;
    }

    @Override
    public RoleEntity get(UUID id) {
        if (id == null) throw HttpException.badRequest("ID must not be null");
        return repository.findById(id).orElseThrow(() -> HttpException.notFound("Role not found with the given ID."));
    }

}
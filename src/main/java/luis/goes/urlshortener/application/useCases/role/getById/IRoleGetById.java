package luis.goes.urlshortener.application.useCases.role.getById;

import luis.goes.urlshortener.domain.entity.role.RoleEntity;

import java.util.UUID;

public interface IRoleGetById {
    RoleEntity get(UUID id);
}
package luis.goes.urlshortener.application.useCases.role.create;

import luis.goes.urlshortener.presentation.dtos.role.RoleRequestDTO;
import luis.goes.urlshortener.presentation.dtos.role.RoleResponseDTO;

public interface IRoleCreate {
    RoleResponseDTO create(RoleRequestDTO dto);
}
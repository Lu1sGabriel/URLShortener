package luis.goes.urlshortener.application.useCases.role.getAll;

import luis.goes.urlshortener.presentation.dtos.role.RoleResponseDTO;

import java.util.List;

public interface IRoleGetAll {
    List<RoleResponseDTO> get();
}
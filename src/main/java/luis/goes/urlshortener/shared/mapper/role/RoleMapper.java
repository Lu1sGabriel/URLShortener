package luis.goes.urlshortener.shared.mapper.role;

import luis.goes.urlshortener.domain.entity.role.RoleEntity;
import luis.goes.urlshortener.presentation.dtos.role.RoleResponseDTO;
import luis.goes.urlshortener.shared.mapper.IMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleMapper implements IMapper<RoleResponseDTO, RoleEntity> {

    @Override
    public RoleResponseDTO toDto(RoleEntity roleEntity) {
        return new RoleResponseDTO(
                roleEntity.getId(),
                roleEntity.getName().getValue(),
                roleEntity.getDescription().getValue(),
                roleEntity.getUsers().stream().map(users -> new RoleResponseDTO.Users(
                        users.getId(),
                        users.getName().getValue(),
                        users.getUserCredentials().getEmail().getValue()
                )).toList()
        );
    }

    @Override
    public List<RoleResponseDTO> toDtoList(List<RoleEntity> roleEntities) {
        return roleEntities.stream()
                .map(this::toDto)
                .toList();
    }

}
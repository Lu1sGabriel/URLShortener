package luis.goes.urlshortener.shared.mapper;

import luis.goes.urlshortener.domain.entity.Mappable;
import luis.goes.urlshortener.presentation.dtos.DTO;

import java.util.List;

public interface IMapper<RequestDTO extends DTO, ResponseDTO extends DTO, Entity extends Mappable> {

    // Entrada: DTO → Entity
    Entity toEntity(RequestDTO dto);

    // Saída: Entity → DTO
    ResponseDTO toDto(Entity entity);

    // Listas
    List<Entity> toEntityList(List<RequestDTO> dtoList);

    List<ResponseDTO> toDtoList(List<Entity> entityList);

}
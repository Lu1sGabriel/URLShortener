package luis.goes.urlshortener.shared.mapper;

import luis.goes.urlshortener.domain.entity.Mappable;
import luis.goes.urlshortener.presentation.dtos.DTO;

import java.util.List;

public interface IMapper<ResponseDTO extends DTO, Entity extends Mappable> {

    ResponseDTO toDto(Entity entity);

    List<ResponseDTO> toDtoList(List<Entity> entityList);

}
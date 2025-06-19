package luis.goes.urlshortener.shared.mapper.user;

import luis.goes.urlshortener.domain.entity.user.UserEntity;
import luis.goes.urlshortener.presentation.dtos.user.UserRequestDTO;
import luis.goes.urlshortener.presentation.dtos.user.UserResponseDto;
import luis.goes.urlshortener.shared.mapper.IMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public final class UserMapper implements IMapper<UserRequestDTO, UserResponseDto, UserEntity> {

    @Override
    public UserEntity toEntity(UserRequestDTO dto) {
        UserEntity user = new UserEntity();
        user.setName(dto.name());
        user.setEmail(dto.email());
        return user;
    }

    @Override
    public UserResponseDto toDto(UserEntity userEntity) {
        return new UserResponseDto(
                userEntity.getId(),
                userEntity.getName().name(),
                userEntity.getEmail().email(),
                userEntity.getDateInfo().getCreatedAt(),
                userEntity.getDateInfo().getUpdatedAt()
        );
    }

    @Override
    public List<UserEntity> toEntityList(List<UserRequestDTO> userRequestDTOS) {
        return userRequestDTOS.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserResponseDto> toDtoList(List<UserEntity> userEntities) {
        return userEntities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

}
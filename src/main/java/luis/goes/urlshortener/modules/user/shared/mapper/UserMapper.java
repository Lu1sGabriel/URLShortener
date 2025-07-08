package luis.goes.urlshortener.modules.user.shared.mapper;

import luis.goes.urlshortener.core.shared.mapper.entityToDto.Mapper;
import luis.goes.urlshortener.modules.user.domain.UserEntity;
import luis.goes.urlshortener.modules.user.presentation.dto.UserResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public final class UserMapper implements Mapper<UserResponseDto, UserEntity> {

    @Override
    public UserResponseDto toDto(UserEntity userEntity) {
        return new UserResponseDto(
                userEntity.getId(),
                userEntity.getName().getValue(),
                userEntity.getUserCredentials().getEmail().getValue(),
                userEntity.getUrls().stream().map(url -> new UserResponseDto.UrlsInfo(
                        url.getUrl().getValue(),
                        url.getShortened()
                )).toList(),
                userEntity.getDateInfo().getCreatedAt(),
                userEntity.getDateInfo().getUpdatedAt()
        );
    }

    @Override
    public List<UserResponseDto> toDtoList(List<UserEntity> userEntities) {
        return userEntities.stream().map(this::toDto).toList();
    }

}
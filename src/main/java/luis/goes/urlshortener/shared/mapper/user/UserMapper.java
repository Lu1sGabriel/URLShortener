package luis.goes.urlshortener.shared.mapper.user;

import luis.goes.urlshortener.domain.entity.user.UserEntity;
import luis.goes.urlshortener.presentation.dtos.user.UserResponseDto;
import luis.goes.urlshortener.shared.mapper.IMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public final class UserMapper implements IMapper<UserResponseDto, UserEntity> {

    @Override
    public UserResponseDto toDto(UserEntity userEntity) {
        return new UserResponseDto(
                userEntity.getId(),
                userEntity.getName().getValue(),
                userEntity.getUserCredentials().getEmail().getValue(),
                userEntity.getUserRole().getName().getValue(),
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
package luis.goes.urlshortener.application.useCases.user;

import luis.goes.urlshortener.domain.entity.user.UserEntity;

public interface IUserUseCases {

    UserEntity create(String name);
}

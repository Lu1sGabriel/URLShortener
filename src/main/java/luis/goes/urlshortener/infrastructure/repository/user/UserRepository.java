package luis.goes.urlshortener.infrastructure.repository.user;

import luis.goes.urlshortener.domain.entity.user.UserEntity;
import luis.goes.urlshortener.domain.valueObject.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByUserCredentials_Email(Email email);
}
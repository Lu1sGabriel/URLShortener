package luis.goes.urlshortener.modules.user.infrastructure.repository;

import luis.goes.urlshortener.modules.user.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByName_Name(String name);

    Optional<UserEntity> findByUserCredentials_Email_Email(String email);

    List<UserEntity> findAllByDateInfoDeletedAtNotNull();
}
package luis.goes.urlshortener.infrastructure.repository.role;

import luis.goes.urlshortener.domain.entity.role.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {
}
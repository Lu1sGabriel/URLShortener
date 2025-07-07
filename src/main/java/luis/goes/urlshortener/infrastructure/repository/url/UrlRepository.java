package luis.goes.urlshortener.infrastructure.repository.url;

import luis.goes.urlshortener.domain.entity.url.URLEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UrlRepository extends JpaRepository<URLEntity, UUID> {
    List<URLEntity> findAllByUser_Id(UUID userId);

    Optional<URLEntity> findByShortened(String shortened);
}
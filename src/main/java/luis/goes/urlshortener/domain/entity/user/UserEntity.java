package luis.goes.urlshortener.domain.entity.user;

import jakarta.persistence.*;
import luis.goes.urlshortener.domain.entity.url.URLEntity;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Table
@Entity(name = "user_db")
public record UserEntity(
        @Id UUID id,
        @Column(name = "name", nullable = false) String name,
        @Column(name = "created_at", nullable = false) Instant createdAt,
        @Column(name = "updated_at", nullable = false) Instant updatedAt,
        @Column(name = "deleted_at") Instant deletedAt,
        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
        Set<URLEntity> urls
) {
    public UserEntity {
    }

    public UserEntity(String name) {
        this(UUID.randomUUID(), name, Instant.now(), Instant.now(), null, new HashSet<>());
    }
}

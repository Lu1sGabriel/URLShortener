package luis.goes.urlshortener.domain.entity.url;

import jakarta.persistence.*;
import luis.goes.urlshortener.domain.entity.user.UserEntity;

import java.util.UUID;

@Table
@Entity(name = "url_db")
public record URLEntity(
        @Id UUID id,
        @Column(name = "original_url", nullable = false) String original,
        @Column(name = "shortened_url", nullable = false) String shortened,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        UserEntity user
) {
    public URLEntity {
    }

    public URLEntity(String original, String shortened, UserEntity user) {
        this(UUID.randomUUID(), original, shortened, user);
    }
}
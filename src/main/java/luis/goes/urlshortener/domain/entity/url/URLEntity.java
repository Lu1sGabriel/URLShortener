package luis.goes.urlshortener.domain.entity.url;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import luis.goes.urlshortener.domain.entity.user.UserEntity;

import java.util.UUID;

@Table
@Entity(name = "url_db")
@Getter
@Setter
public class URLEntity {

    @Id
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(name = "original_url", nullable = false)
    private String original;

    @Column(name = "shortened_url", nullable = false)
    private String shortened;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    public URLEntity() {
    }

    public URLEntity(String original, String shortened, UserEntity user) {
        this.id = UUID.randomUUID();
        this.original = original;
        this.shortened = shortened;
        this.user = user;
    }

}
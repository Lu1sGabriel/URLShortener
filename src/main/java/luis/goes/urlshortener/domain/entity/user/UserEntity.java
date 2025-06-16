package luis.goes.urlshortener.domain.entity.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import luis.goes.urlshortener.domain.entity.Mappable;
import luis.goes.urlshortener.domain.entity.url.URLEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "user_db")
@Table
@Getter
@Setter
public class UserEntity implements Mappable {

    @Id
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Embedded
    public UserDateInfo dateInfo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<URLEntity> urls = new HashSet<>();


    public UserEntity() {
        this.id = UUID.randomUUID();
        this.dateInfo = new UserDateInfo();
    }

    public UserEntity(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.dateInfo = new UserDateInfo();
    }

}
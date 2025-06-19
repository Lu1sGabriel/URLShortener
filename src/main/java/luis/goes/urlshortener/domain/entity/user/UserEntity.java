package luis.goes.urlshortener.domain.entity.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import luis.goes.urlshortener.domain.entity.Mappable;
import luis.goes.urlshortener.domain.entity.url.URLEntity;
import luis.goes.urlshortener.domain.types.Email;
import luis.goes.urlshortener.domain.types.Name;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "user_db")
@Table(
        name = "user_db",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_user_name", columnNames = {"name"}),
                @UniqueConstraint(name = "uk_user_email", columnNames = {"email"})
        }
)
@Getter
@Setter
public class UserEntity implements Mappable {

    @Id
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "name", nullable = false, unique = true))
    private Name name;

    @Embedded
    @AttributeOverride(name = "email", column = @Column(name = "email", nullable = false, unique = true))
    private Email email;

    @Embedded
    public UserDateInfo dateInfo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<URLEntity> urls = new HashSet<>();

    public UserEntity() {
        this.id = UUID.randomUUID();
        this.dateInfo = new UserDateInfo();
    }

    public UserEntity(String name, String email) {
        this.id = UUID.randomUUID();
        this.name = new Name(name);
        this.email = new Email(email);
        this.dateInfo = new UserDateInfo();
    }

    public void setName(String name) {
        this.name = new Name(name);
    }

    public void setEmail(String email) {
        this.email = new Email(email);
    }

}
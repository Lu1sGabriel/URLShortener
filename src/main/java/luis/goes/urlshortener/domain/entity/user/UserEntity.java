package luis.goes.urlshortener.domain.entity.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import luis.goes.urlshortener.domain.entity.Mappable;
import luis.goes.urlshortener.domain.entity.url.URLEntity;
import luis.goes.urlshortener.domain.valueObjects.Name;

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
@NoArgsConstructor
@Getter
public class UserEntity implements Mappable {

    @Id
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "name", nullable = false, unique = true))
    private Name name;

    @Embedded
    private UserCredentials userCredentials;

    @Embedded
    public UserDateInfo dateInfo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<URLEntity> urls = new HashSet<>();

    public UserEntity(String name, String email, String password) {
        this.id = UUID.randomUUID();
        this.name = new Name(name);
        this.userCredentials = new UserCredentials(email, password);
        this.dateInfo = new UserDateInfo();
    }

    public void changeName(String name) {
        this.name.change(name);
    }

    public void changeUserEmail(String email) {
        this.userCredentials.getEmail().change(email);
    }

    public void changeUserPassword(String password) {
        this.userCredentials.getPassword().change(password);
    }

}
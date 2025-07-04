package luis.goes.urlshortener.domain.entity.role;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import luis.goes.urlshortener.domain.entity.Mappable;
import luis.goes.urlshortener.domain.entity.user.UserEntity;
import luis.goes.urlshortener.domain.valueObject.Description;
import luis.goes.urlshortener.domain.valueObject.Name;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "role_db",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_role_name", columnNames = {"name"})
        })
@NoArgsConstructor
@Getter
public class RoleEntity implements Mappable {
    @Id
    private UUID id;

    @Column(name = "name", nullable = false, unique = true)
    private Name name;

    @Column(name = "description", nullable = false)
    private Description description;

    @OneToMany(mappedBy = "userRole")
    private Set<UserEntity> users = new HashSet<>();

    public RoleEntity(String name, String description) {
        this.id = UUID.randomUUID();
        this.name = new Name(name);
        this.description = new Description(description);
    }

}
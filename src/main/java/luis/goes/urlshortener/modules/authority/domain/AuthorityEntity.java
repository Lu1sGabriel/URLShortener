package luis.goes.urlshortener.modules.authority.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import luis.goes.urlshortener.core.shared.mapper.entityToDto.Mappable;
import luis.goes.urlshortener.modules.authority.domain.enums.IAuthority;

import java.util.UUID;

@Entity
@Table(name = "authority_db")
@NoArgsConstructor
@Getter
public class AuthorityEntity implements Mappable {

    @Id
    private UUID id;

    @Column(name = "authority", nullable = false, unique = true)
    private String authority;

    @Column(name = "description", nullable = false)
    private String description;

    public AuthorityEntity(IAuthority authority) {
        this.id = UUID.randomUUID();
        this.authority = authority.getValue();
        this.description = authority.getDescription();
    }

}
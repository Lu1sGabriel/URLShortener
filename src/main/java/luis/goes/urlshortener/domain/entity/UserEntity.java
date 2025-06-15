package luis.goes.urlshortener.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Table
@Entity(name = "user_db")
public record UserEntity(
        @Id UUID id,
        @Column(name = "name", nullable = false) String name) {

    public UserEntity(String name) {
        this(UUID.randomUUID(), name);
    }

}
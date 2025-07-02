package luis.goes.urlshortener.domain.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import luis.goes.urlshortener.domain.valueObjects.Email;
import luis.goes.urlshortener.domain.valueObjects.Password;


@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class UserCredentials {
    @Column(name = "email", nullable = false, unique = true)
    private Email email;

    @Column(name = "password", nullable = false)
    private Password password;

    public UserCredentials(String email, String password) {
        this.email = new Email(email);
        this.password = new Password(password);
    }

    public void changeEmail(String newEmail) {
        this.email = new Email(newEmail);
    }

    public void changePassword(String newPassword) {
        this.password = new Password(newPassword);
    }

}
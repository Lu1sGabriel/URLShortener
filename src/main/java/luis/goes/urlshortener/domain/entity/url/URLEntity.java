package luis.goes.urlshortener.domain.entity.url;

import jakarta.persistence.*;
import lombok.Getter;
import luis.goes.urlshortener.domain.entity.Mappable;
import luis.goes.urlshortener.domain.entity.user.UserEntity;
import luis.goes.urlshortener.domain.valueObject.Url;
import luis.goes.urlshortener.domain.valueObject.UrlName;

import java.util.UUID;

@Table
@Entity(name = "url_db")
@Getter
public class URLEntity implements Mappable {

    @Id
    private UUID id;

    @Embedded
    @AttributeOverride(name = "url_name", column = @Column(name = "url_name", nullable = false))
    private UrlName urlName;

    @Embedded
    @AttributeOverride(name = "url", column = @Column(name = "url", nullable = false))
    private Url url;

    @Column(name = "shortened", nullable = false)
    private String shortened;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    public URLEntity() {
    }

    public URLEntity(String urlName, String url, String shortened, UserEntity user) {
        this.id = UUID.randomUUID();
        this.urlName = new UrlName(urlName);
        this.url = new Url(url);
        this.shortened = shortened;
        this.user = user;
    }

    public void changeUrlName(String urlName) {
        this.urlName = new UrlName(urlName);
    }

    public void changeOriginalUrl(String url) {
        this.url = new Url(url);
    }

}
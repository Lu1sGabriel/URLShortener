package luis.goes.urlshortener.application.useCases.url;

import lombok.Getter;
import luis.goes.urlshortener.application.useCases.url.changeUrl.IUrlChangeUrl;
import luis.goes.urlshortener.application.useCases.url.changeUrlName.IUrlChangeUrlName;
import luis.goes.urlshortener.application.useCases.url.create.IUrlCreate;
import luis.goes.urlshortener.application.useCases.url.delete.IUrlDelete;
import luis.goes.urlshortener.application.useCases.url.getAll.IUrlGetAll;
import luis.goes.urlshortener.application.useCases.url.getAllByUserId.IUrlGetByUserId;
import luis.goes.urlshortener.application.useCases.url.getByUlrShortenedId.IUrlGetByUrlShortenedId;
import org.springframework.stereotype.Component;

@Component
@Getter
public class UrlUseCases {
    private final IUrlGetByUrlShortenedId byUrlShortenedId;
    private final IUrlGetAll all;
    private final IUrlGetByUserId byUserId;
    private final IUrlCreate create;
    private final IUrlChangeUrl changeUrl;
    private final IUrlChangeUrlName changeUrlName;
    private final IUrlDelete delete;


    public UrlUseCases(IUrlGetByUrlShortenedId byUrlShortenedId, IUrlGetAll all, IUrlGetByUserId byUserId, IUrlCreate create,
                       IUrlChangeUrl changeUrl, IUrlChangeUrlName changeUrlName, IUrlDelete delete) {
        this.byUrlShortenedId = byUrlShortenedId;
        this.all = all;
        this.byUserId = byUserId;
        this.create = create;
        this.changeUrl = changeUrl;
        this.changeUrlName = changeUrlName;
        this.delete = delete;
    }

}
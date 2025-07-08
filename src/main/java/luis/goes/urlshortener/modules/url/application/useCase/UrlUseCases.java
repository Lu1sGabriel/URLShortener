package luis.goes.urlshortener.modules.url.application.useCase;

import lombok.Getter;
import luis.goes.urlshortener.modules.url.application.useCase.changeUrl.IUrlChangeUrl;
import luis.goes.urlshortener.modules.url.application.useCase.changeUrlName.IUrlChangeUrlName;
import luis.goes.urlshortener.modules.url.application.useCase.create.IUrlCreate;
import luis.goes.urlshortener.modules.url.application.useCase.delete.IUrlDelete;
import luis.goes.urlshortener.modules.url.application.useCase.getAll.IUrlGetAll;
import luis.goes.urlshortener.modules.url.application.useCase.getAllByUserId.IUrlGetByUserId;
import luis.goes.urlshortener.modules.url.application.useCase.getByUlrShortenedId.IUrlGetByUrlShortenedId;
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
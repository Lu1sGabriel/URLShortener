package luis.goes.urlshortener.application.useCases.role;

import lombok.Getter;
import luis.goes.urlshortener.application.useCases.role.create.IRoleCreate;
import luis.goes.urlshortener.application.useCases.role.getAll.IRoleGetAll;
import luis.goes.urlshortener.application.useCases.role.getById.IRoleGetById;
import org.springframework.stereotype.Component;

@Component
@Getter
public class RoleUseCases {
    private final IRoleGetById byId;
    private final IRoleGetAll all;
    private final IRoleCreate create;

    public RoleUseCases(IRoleGetById byId, IRoleGetAll all, IRoleCreate create) {
        this.byId = byId;
        this.all = all;
        this.create = create;
    }

}
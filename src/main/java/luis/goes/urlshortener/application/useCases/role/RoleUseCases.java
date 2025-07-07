package luis.goes.urlshortener.application.useCases.role;

import lombok.Getter;
import luis.goes.urlshortener.application.useCases.role.create.IRoleCreate;
import luis.goes.urlshortener.application.useCases.role.getAll.IRoleGetAll;
import org.springframework.stereotype.Component;

@Component
@Getter
public class RoleUseCases {
    private final IRoleGetAll all;
    private final IRoleCreate create;

    public RoleUseCases(IRoleGetAll all, IRoleCreate create) {
        this.all = all;
        this.create = create;
    }

}
package luis.goes.urlshortener.modules.user.application.useCase;

import lombok.Getter;
import luis.goes.urlshortener.modules.user.application.useCase.changeEmail.IUserChangeEmail;
import luis.goes.urlshortener.modules.user.application.useCase.changeName.IUserChangeName;
import luis.goes.urlshortener.modules.user.application.useCase.changePassword.IUserChangePassword;
import luis.goes.urlshortener.modules.user.application.useCase.create.IUserCreate;
import luis.goes.urlshortener.modules.user.application.useCase.deactivate.IUserDeactivate;
import luis.goes.urlshortener.modules.user.application.useCase.getAll.IUserGetAll;
import luis.goes.urlshortener.modules.user.application.useCase.getById.IUserGetById;
import org.springframework.stereotype.Component;

@Component
@Getter
public class UserUseCases {

    private final IUserGetById byId;
    private final IUserGetAll all;
    private final IUserCreate create;
    private final IUserDeactivate deactivate;
    private final IUserChangePassword changePassword;
    private final IUserChangeEmail changeEmail;
    private final IUserChangeName changeName;

    public UserUseCases(IUserGetById byId, IUserGetAll all, IUserCreate create, IUserDeactivate deactivate,
                        IUserChangePassword userChangePasswordUseCase, IUserChangeEmail changeEmail,
                        IUserChangeName userChangeNameUseCase) {
        this.byId = byId;
        this.all = all;
        this.create = create;
        this.deactivate = deactivate;
        this.changePassword = userChangePasswordUseCase;
        this.changeEmail = changeEmail;
        this.changeName = userChangeNameUseCase;
    }

}
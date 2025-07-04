package luis.goes.urlshortener.application.useCases.user;

import lombok.Getter;
import luis.goes.urlshortener.application.useCases.user.changeEmail.IUserChangeEmail;
import luis.goes.urlshortener.application.useCases.user.changeName.IUserChangeName;
import luis.goes.urlshortener.application.useCases.user.changePassword.IUserChangePassword;
import luis.goes.urlshortener.application.useCases.user.create.IUserCreate;
import luis.goes.urlshortener.application.useCases.user.deactivate.IUserDeactivate;
import luis.goes.urlshortener.application.useCases.user.getAll.IUserGetAll;
import luis.goes.urlshortener.application.useCases.user.getById.IUserGetById;
import luis.goes.urlshortener.application.useCases.user.login.IUserLogin;
import org.springframework.stereotype.Component;

@Component
@Getter
public class UserUseCases {

    private final IUserGetById byId;
    private final IUserGetAll all;
    private final IUserCreate create;
    private final IUserLogin login;
    private final IUserDeactivate deactivate;
    private final IUserChangePassword changePassword;
    private final IUserChangeEmail changeEmail;
    private final IUserChangeName changeName;

    public UserUseCases(IUserGetById byId, IUserGetAll all, IUserCreate create, IUserLogin userLoginUseCase, IUserDeactivate deactivate,
                        IUserChangePassword userChangePasswordUseCase, IUserChangeEmail changeEmail,
                        IUserChangeName userChangeNameUseCase) {
        this.byId = byId;
        this.all = all;
        this.create = create;
        this.login = userLoginUseCase;
        this.deactivate = deactivate;
        this.changePassword = userChangePasswordUseCase;
        this.changeEmail = changeEmail;
        this.changeName = userChangeNameUseCase;
    }

}
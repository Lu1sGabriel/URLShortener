package luis.goes.urlshortener.modules.user.application.useCase;

import lombok.Getter;
import luis.goes.urlshortener.modules.user.application.useCase.changeEmail.IUserChangeEmail;
import luis.goes.urlshortener.modules.user.application.useCase.changeName.IUserChangeName;
import luis.goes.urlshortener.modules.user.application.useCase.changePassword.IUserChangePassword;
import luis.goes.urlshortener.modules.user.application.useCase.create.IUserCreate;
import luis.goes.urlshortener.modules.user.application.useCase.deactivate.IUserDeactivate;
import luis.goes.urlshortener.modules.user.application.useCase.getMethods.IUserGetters;
import org.springframework.stereotype.Component;

@Component
@Getter
public class UserUseCases {

    private final IUserGetters getters;
    private final IUserCreate create;
    private final IUserDeactivate deactivate;
    private final IUserChangePassword changePassword;
    private final IUserChangeEmail changeEmail;
    private final IUserChangeName changeName;

    public UserUseCases(IUserGetters getters, IUserCreate create, IUserDeactivate deactivate,
                        IUserChangePassword changePassword, IUserChangeEmail changeEmail, IUserChangeName changeName) {
        this.getters = getters;
        this.create = create;
        this.deactivate = deactivate;
        this.changePassword = changePassword;
        this.changeEmail = changeEmail;
        this.changeName = changeName;
    }

}
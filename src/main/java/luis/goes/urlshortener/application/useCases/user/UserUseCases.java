package luis.goes.urlshortener.application.useCases.user;

import lombok.Getter;
import luis.goes.urlshortener.application.useCases.user.changeEmail.IUserChangeEmailUseCase;
import luis.goes.urlshortener.application.useCases.user.changeName.IUserChangeNameUseCase;
import luis.goes.urlshortener.application.useCases.user.changePassword.IUserChangePasswordUseCase;
import luis.goes.urlshortener.application.useCases.user.create.IUserCreateUseCase;
import luis.goes.urlshortener.application.useCases.user.deactivate.IUserDeactivateUseCase;
import luis.goes.urlshortener.application.useCases.user.login.IUserLoginUseCase;
import org.springframework.stereotype.Component;

@Component
@Getter
public class UserUseCases {

    private final IUserCreateUseCase userCreateUseCase;
    private final IUserLoginUseCase userLoginUseCase;
    private final IUserDeactivateUseCase userDeactivateUseCase;
    private final IUserChangePasswordUseCase userChangePasswordUseCase;
    private final IUserChangeEmailUseCase userChangeEmailUseCase;
    private final IUserChangeNameUseCase userChangeNameUseCase;

    public UserUseCases(IUserCreateUseCase userCreateUseCase, IUserLoginUseCase userLoginUseCase, IUserDeactivateUseCase userDeactivateUseCase,
                        IUserChangePasswordUseCase userChangePasswordUseCase, IUserChangeEmailUseCase userChangeEmailUseCase,
                        IUserChangeNameUseCase userChangeNameUseCase) {
        this.userCreateUseCase = userCreateUseCase;
        this.userLoginUseCase = userLoginUseCase;
        this.userDeactivateUseCase = userDeactivateUseCase;
        this.userChangePasswordUseCase = userChangePasswordUseCase;
        this.userChangeEmailUseCase = userChangeEmailUseCase;
        this.userChangeNameUseCase = userChangeNameUseCase;
    }

}
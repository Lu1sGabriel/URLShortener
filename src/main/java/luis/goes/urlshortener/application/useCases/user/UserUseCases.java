package luis.goes.urlshortener.application.useCases.user;

import luis.goes.urlshortener.application.useCases.user.create.IUserCreateUseCase;
import luis.goes.urlshortener.application.useCases.user.deactivate.IUserDeactivateUseCase;
import org.springframework.stereotype.Component;

@Component
public class UserUseCases {

    private final IUserCreateUseCase userCreateUseCase;
    private final IUserDeactivateUseCase userDeactivateUseCase;

    public UserUseCases(IUserCreateUseCase userCreateUseCase, IUserDeactivateUseCase userDeactivateUseCase) {
        this.userCreateUseCase = userCreateUseCase;
        this.userDeactivateUseCase = userDeactivateUseCase;
    }

    public IUserCreateUseCase getUserCreateUseCase() {
        return userCreateUseCase;
    }

    public IUserDeactivateUseCase getUserDeactivateUseCase() {
        return userDeactivateUseCase;
    }

}
package luis.goes.urlshortener.modules.authority.domain.enums;

import lombok.Getter;

@Getter
public enum AuthorityUser implements IAuthority {

    VIEW_PROFILE("user:view-profile", "View own profile"),
    VIEW_ALL("user:view-all", "View all users"),
    CHANGE_PASSWORD("user:change-password", "Change user password"),
    CHANGE_NAME("user:change-name", "Change user name"),
    CHANGE_EMAIL("user:change-email", "Change user email"),
    DEACTIVATE("user:deactivate", "Deactivate user account");

    private final String value;
    private final String description;

    AuthorityUser(String value, String description) {
        this.value = value;
        this.description = description;
    }


}
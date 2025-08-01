package luis.goes.urlshortener.core.authorities;

import luis.goes.urlshortener.modules.authority.domain.enums.AuthorityUser;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.stereotype.Component;

@Component
public class RouterAuthorityUserSecurity implements IRouterAuthoritySecurity {

    @Override
    public void configure(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry auth) {
        auth
                .requestMatchers(HttpMethod.GET, "/api/v1/user/me").hasAuthority(AuthorityUser.VIEW_PROFILE.getValue())
                .requestMatchers(HttpMethod.GET, "/api/v1/user/all/deactivated").hasAuthority(AuthorityUser.VIEW_ALL_DEACTIVATED.getValue())
                .requestMatchers(HttpMethod.GET, "/api/v1/user/name/*").hasAuthority(AuthorityUser.GET_BY_NAME.getValue())
                .requestMatchers(HttpMethod.GET, "/api/v1/user/email/*").hasAuthority(AuthorityUser.GET_BY_EMAIL.getValue())
                .requestMatchers(HttpMethod.GET, "/api/v1/user").hasAuthority(AuthorityUser.VIEW_ALL.getValue())
                .requestMatchers(HttpMethod.GET, "/api/v1/user/activate").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/v1/user/userAuthorities").hasAuthority(AuthorityUser.VIEW_ALL_AUTHORITIES.getValue())
                .requestMatchers(HttpMethod.POST, "/api/v1/user").permitAll()
                .requestMatchers(HttpMethod.PATCH, "/api/v1/user/password").hasAuthority(AuthorityUser.CHANGE_PASSWORD.getValue())
                .requestMatchers(HttpMethod.PATCH, "/api/v1/user/name").hasAuthority(AuthorityUser.CHANGE_NAME.getValue())
                .requestMatchers(HttpMethod.PATCH, "/api/v1/user/email").hasAuthority(AuthorityUser.CHANGE_EMAIL.getValue())
                .requestMatchers(HttpMethod.DELETE, "/api/v1/user").hasAuthority(AuthorityUser.DEACTIVATE.getValue());
    }

}
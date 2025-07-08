package luis.goes.urlshortener.core.infrastructure.configuration.matchers;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.stereotype.Component;

@Component
public class UserSecurityMatcher implements ISecurityMatcher {

    @Override
    public void configure(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry auth) {
        auth
                .requestMatchers(HttpMethod.GET, "/api/v1/user/me").hasAuthority("user:view-profile")
                .requestMatchers(HttpMethod.GET, "/api/v1/user").hasAuthority("user:view-all")
                .requestMatchers(HttpMethod.POST, "/api/v1/user").permitAll()
                .requestMatchers(HttpMethod.PATCH, "/api/v1/user/password/**").hasAuthority("user:change-password")
                .requestMatchers(HttpMethod.PATCH, "/api/v1/user/name/**").hasAuthority("user:change-name")
                .requestMatchers(HttpMethod.PATCH, "/api/v1/user/email/**").hasAuthority("user:change-email")
                .requestMatchers(HttpMethod.DELETE, "/api/v1/user/**").hasAuthority("user:deactivate");
    }

}
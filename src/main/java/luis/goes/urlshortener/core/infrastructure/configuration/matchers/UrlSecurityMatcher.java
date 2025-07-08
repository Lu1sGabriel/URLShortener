package luis.goes.urlshortener.core.infrastructure.configuration.matchers;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.stereotype.Component;

@Component
public class UrlSecurityMatcher implements ISecurityMatcher {

    @Override
    public void configure(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry auth) {
        auth
                .requestMatchers(HttpMethod.GET, "/api/v1/url").hasAuthority("url:view-all")
                .requestMatchers(HttpMethod.GET, "/api/v1/url/user/**").hasAuthority("url:view")
                .requestMatchers(HttpMethod.POST, "/api/v1/url").hasAuthority("url:create")
                .requestMatchers(HttpMethod.PATCH, "/api/v1/url/change/url-name").hasAuthority("url:change-name")
                .requestMatchers(HttpMethod.PATCH, "/api/v1/url/change/url").hasAuthority("url:change-url")
                .requestMatchers(HttpMethod.DELETE, "/api/v1/url/**").hasAuthority("url:delete");
    }

}
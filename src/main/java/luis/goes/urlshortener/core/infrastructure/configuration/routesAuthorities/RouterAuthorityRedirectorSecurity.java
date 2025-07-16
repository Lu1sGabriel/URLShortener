package luis.goes.urlshortener.core.infrastructure.configuration.routesAuthorities;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.stereotype.Component;

@Component
public class RouterAuthorityRedirectorSecurity implements IRouterAuthoritySecurity {

    @Override
    public void configure(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry auth) {
        auth.requestMatchers(HttpMethod.GET, "/redirector/*").permitAll();
    }

}
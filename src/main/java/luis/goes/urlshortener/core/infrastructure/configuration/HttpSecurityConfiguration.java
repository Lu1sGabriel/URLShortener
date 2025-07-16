package luis.goes.urlshortener.core.infrastructure.configuration;

import luis.goes.urlshortener.core.exception.CustomAccessDeniedHandler;
import luis.goes.urlshortener.core.exception.CustomAuthenticationEntryPointHandler;
import luis.goes.urlshortener.core.infrastructure.auth.CheckUserEnabledFilter;
import luis.goes.urlshortener.core.infrastructure.configuration.routesAuthorities.IRouterAuthoritySecurity;
import luis.goes.urlshortener.modules.user.infrastructure.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
public class HttpSecurityConfiguration {

    private final List<IRouterAuthoritySecurity> securityMatchers;
    private final UserRepository userRepository;
    private final JwtAuthenticationConverter jwtAuthenticationConverter;

    public HttpSecurityConfiguration(List<IRouterAuthoritySecurity> securityMatchers, UserRepository userRepository, JwtAuthenticationConverter jwtAuthenticationConverter) {
        this.securityMatchers = securityMatchers;
        this.userRepository = userRepository;
        this.jwtAuthenticationConverter = jwtAuthenticationConverter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    for (IRouterAuthoritySecurity matcher : securityMatchers) {
                        matcher.configure(auth);
                    }
                    auth.anyRequest().authenticated();
                })
                .addFilterBefore(new CheckUserEnabledFilter(userRepository), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(exception -> exception
                        .accessDeniedHandler(new CustomAccessDeniedHandler())
                        .authenticationEntryPoint(new CustomAuthenticationEntryPointHandler())
                )
                .httpBasic(Customizer.withDefaults())
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter))
                )
                .build();
    }

}
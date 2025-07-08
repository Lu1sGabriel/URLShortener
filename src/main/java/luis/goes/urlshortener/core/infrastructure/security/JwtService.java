package luis.goes.urlshortener.core.infrastructure.security;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private static final String ISSUER = "spring-security-jwt";
    private static final String PERMISSIONS_CLAIM = "permission";
    private static final String USER_ID_CLAIM = "userId";

    private final JwtEncoder encoder;
    private final long expirySeconds;

    public JwtService(JwtEncoder encoder, @Value("${jwt.expiry-seconds:3600}") long expirySeconds) {
        this.encoder = encoder;
        this.expirySeconds = expirySeconds;
    }

    public String generateToken(Authentication authentication) {
        Object principal = authentication.getPrincipal();

        if (!(principal instanceof UserAuthenticated user)) {
            throw new IllegalArgumentException("Principal must be of type UserAuthenticated");
        }

        JwtClaimsSet claims = buildClaims(authentication, user);

        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    private JwtClaimsSet buildClaims(Authentication authentication, UserAuthenticated user) {
        Instant now = Instant.now();

        return JwtClaimsSet.builder()
                .issuer(ISSUER)
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expirySeconds))
                .subject(authentication.getName())
                .claim(PERMISSIONS_CLAIM, authentication.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .sorted()
                        .collect(Collectors.toList()))
                .claim(USER_ID_CLAIM, user.getId())
                .build();
    }

}
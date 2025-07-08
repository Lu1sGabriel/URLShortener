package luis.goes.urlshortener.core.shared.utils;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public final class JwtUtils {

    private JwtUtils() {
    }

    public static Jwt getCurrentJwt() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !(auth.getPrincipal() instanceof Jwt jwt)) {
            throw new IllegalStateException("Não há JWT no SecurityContext");
        }
        return jwt;
    }


    public static UUID getCurrentUserId() {
        String raw = getCurrentJwt().getClaimAsString("userId");
        return UUID.fromString(raw);
    }

    public static String getCurrentUsername() {
        return getCurrentJwt().getSubject();
    }

    public static List<String> getCurrentPermissions() {
        String permission = getCurrentJwt().getClaimAsString("permission");
        return permission == null ? List.of()
                : Arrays.stream(permission.split(" "))
                .filter(s -> !s.isBlank())
                .toList();
    }

}
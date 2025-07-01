package luis.goes.urlshortener.shared.utils;

import org.springframework.core.env.Environment;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public final class PasswordHashUtil {

    private static boolean isDev = false;

    public PasswordHashUtil(Environment environment) {
        String[] activeProfiles = environment.getActiveProfiles();
        for (String profile : activeProfiles) {
            if (profile.equalsIgnoreCase("dev") || profile.equalsIgnoreCase("test")) {
                isDev = true;
                break;
            }
        }
    }

    public static String hash(String password) {
        if (isDev) {
            return new Argon2PasswordEncoder(16, 32, 1, 4096, 1).encode(password);
        }
        return new Argon2PasswordEncoder(16, 32, 1, 15360, 2).encode(password);
    }

}
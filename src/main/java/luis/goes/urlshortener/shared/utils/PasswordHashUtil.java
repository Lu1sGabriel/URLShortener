package luis.goes.urlshortener.shared.utils;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

final public class PasswordHashUtil {
    private PasswordHashUtil() {
    }

    public static String hash(String password) {
        Argon2PasswordEncoder arg2SpringSecurity = new Argon2PasswordEncoder(16, 32, 1, 15360, 2);
        return arg2SpringSecurity.encode(password);
    }

}
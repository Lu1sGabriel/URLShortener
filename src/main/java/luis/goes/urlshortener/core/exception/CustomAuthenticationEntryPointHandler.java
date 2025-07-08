package luis.goes.urlshortener.core.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import luis.goes.urlshortener.core.shared.dto.ErrorResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPointHandler implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");

        // Mensagem personalizada dependendo do tipo de erro
        String message = "JWT token is missing or invalid.";

        // Opcional: pode verificar o tipo de exceção para personalizar ainda mais
        if (authException.getCause() instanceof JwtException) {
            message = "JWT token is malformed, expired, or unsupported.";
        }

        ErrorResponse errorResponse = new ErrorResponse(
                message,
                HttpServletResponse.SC_UNAUTHORIZED
        );

        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }

}

package luis.goes.urlshortener.presentation.exception;

import luis.goes.urlshortener.shared.helpers.statusCode.StatusCode;

public class ApiException {

    public static abstract class HttpException extends RuntimeException {
        private final int statusCode;

        public HttpException(String message, StatusCode statusCode) {
            super(message);
            this.statusCode = statusCode.getCode();
        }

        public int getStatusCode() {
            return statusCode;
        }
    }

    public static class NotFound extends HttpException {
        public NotFound(String message) {
            super(message, StatusCode.NOT_FOUND);
        }
    }

    public static class BadRequest extends HttpException {
        public BadRequest(String message) {
            super(message, StatusCode.BAD_REQUEST);
        }
    }

    public static class Unauthorized extends HttpException {
        public Unauthorized(String message) {
            super(message, StatusCode.UNAUTHORIZED);
        }
    }

    public static class Forbidden extends HttpException {
        public Forbidden(String message) {
            super(message, StatusCode.FORBIDDEN);
        }
    }

}
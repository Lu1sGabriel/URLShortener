package luis.goes.urlshortener.presentation.exception;

import luis.goes.urlshortener.shared.helpers.statusCode.StatusCode;

public class HttpException extends RuntimeException {
    private final int statusCode;

    public HttpException(String message, StatusCode statusCode) {
        super(message);
        this.statusCode = statusCode.getCode();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public static HttpException notFound(String message) {
        return new HttpException(message, StatusCode.NOT_FOUND);
    }

    public static HttpException badRequest(String message) {
        return new HttpException(message, StatusCode.BAD_REQUEST);
    }

    public static HttpException unauthorized(String message) {
        return new HttpException(message, StatusCode.UNAUTHORIZED);
    }

    public static HttpException forbidden(String message) {
        return new HttpException(message, StatusCode.FORBIDDEN);
    }
}

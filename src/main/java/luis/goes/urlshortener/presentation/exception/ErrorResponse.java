package luis.goes.urlshortener.presentation.exception;

import luis.goes.urlshortener.shared.helpers.statusCode.StatusCode;

public record ErrorResponse(boolean success, String message, int statusCode) {

    public ErrorResponse(String message, StatusCode statusCode) {
        this(false, message, statusCode.getCode());
    }

    public ErrorResponse(String message, int statusCode) {
        this(false, message, statusCode);
    }
}

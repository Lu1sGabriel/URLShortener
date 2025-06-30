package luis.goes.urlshortener.presentation.exception;

import luis.goes.urlshortener.shared.helpers.statusCode.StatusCode;

public record ErrorResponse(String message, int statusCode) {

    public ErrorResponse(String message, StatusCode statusCode) {
        this(message, statusCode.getCode());
    }

}
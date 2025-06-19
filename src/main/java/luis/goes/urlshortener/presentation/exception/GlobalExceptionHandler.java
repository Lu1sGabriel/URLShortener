package luis.goes.urlshortener.presentation.exception;

import luis.goes.urlshortener.shared.helpers.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ApiException.HttpException.class)
    public ResponseEntity<ErrorResponse> handleHttpException(ApiException.HttpException ex) {
        LOGGER.warn("Handled API exception: {}", ex.getMessage());
        ErrorResponse error = new ErrorResponse(ex.getMessage(), ex.getStatusCode());
        return ResponseEntity.status(ex.getStatusCode()).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        LOGGER.error("Unhandled exception caught", ex);
        ErrorResponse error = new ErrorResponse(
                "Internal server error. That's not your fault!",
                StatusCode.INTERNAL_SERVER_ERROR
        );
        return ResponseEntity
                .status(StatusCode.INTERNAL_SERVER_ERROR.getCode())
                .body(error);
    }

}
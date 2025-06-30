package luis.goes.urlshortener.presentation.exception;

import luis.goes.urlshortener.shared.helpers.constraintName.ConstraintNameMapper;
import luis.goes.urlshortener.shared.helpers.statusCode.StatusCode;
import org.hibernate.PropertyValueException;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleUniqueConstrainViolationKeys(Exception ex) {
        String constraintName = ((ConstraintViolationException) ex.getCause()).getConstraintName();

        String fieldName = ConstraintNameMapper.getFieldName(constraintName);

        LOGGER.warn("Handled JPA exception: {}", ex.getMessage());

        ErrorResponse error = new ErrorResponse(
                "Field '" + fieldName + "' already has a value",
                StatusCode.CONFLICT
        );

        return ResponseEntity.status(error.statusCode()).body(error);
    }


    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<ErrorResponse> handleNullableException(PropertyValueException ex) {
        LOGGER.error("Null value in not-null field", ex);

        String property = ex.getPropertyName();
        String entity = ex.getEntityName();

        ErrorResponse error = new ErrorResponse(
                String.format("The required field '%s' in entity '%s' was not provided.", property, entity),
                StatusCode.BAD_REQUEST
        );

        return ResponseEntity.status(error.statusCode()).body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleJsonInvalid(HttpMessageNotReadableException ex) {
        LOGGER.error("Invalid JSON", ex);

        ErrorResponse error = new ErrorResponse(
                "The JSON sent in the request is invalid. Please check the syntax.",
                StatusCode.BAD_REQUEST
        );

        return ResponseEntity.status(error.statusCode()).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        LOGGER.error("Unhandled exception caught", ex);
        ErrorResponse error = new ErrorResponse(
                "Internal server error. That's not your fault!",
                StatusCode.INTERNAL_SERVER_ERROR
        );
        return ResponseEntity.status(error.statusCode()).body(error);
    }

}
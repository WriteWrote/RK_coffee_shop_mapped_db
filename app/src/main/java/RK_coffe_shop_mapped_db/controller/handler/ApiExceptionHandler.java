package RK_coffe_shop_mapped_db.controller.handler;

import RK_coffe_shop_mapped_db.exception.InternalError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ExceptionResponse> handle(Exception exception) {
        var exceptionResponse = new ExceptionResponse(exception, exception.getMessage());
        logger.error("Api exception: {}", exceptionResponse);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<ExceptionResponse> handle(RuntimeException exception) {
        var exceptionResponse = new ExceptionResponse(exception, exception.getMessage());
        logger.error("Api runtime exception: {}", exceptionResponse);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NoSuchFieldException.class})
    public ResponseEntity<ExceptionResponse> handle(NoSuchFieldException exception) {
        var exceptionResponse = new ExceptionResponse(exception, exception.getMessage());
        logger.error("Api NoSuchFieldException: {}", exceptionResponse);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handle(InternalError exception) {
        var exceptionResponse = new ExceptionResponse(exception, exception.getMessage());
        logger.error("Api NoSuchFieldException: {}", exceptionResponse);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}

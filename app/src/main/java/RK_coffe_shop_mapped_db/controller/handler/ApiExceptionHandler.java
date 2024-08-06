package RK_coffe_shop_mapped_db.controller.handler;

import RK_coffe_shop_mapped_db.exception.InternalError;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {
//    @ExceptionHandler(value = {Exception.class})
//    public ResponseEntity<ExceptionResponse> handle(Exception exception) {
//        var exceptionResponse = new ExceptionResponse(exception, exception.getMessage());
//        log.error("Api exception: {}", exceptionResponse);
//        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<ExceptionResponse> handle(RuntimeException exception) {
        var exceptionResponse = new ExceptionResponse(exception, exception.getMessage());
        log.error("Api runtime exception: {}", exceptionResponse);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handle(InternalError exception) {
        var exceptionResponse = new ExceptionResponse(exception, exception.getMessage());
        log.error("Api NoSuchFieldException: {}", exceptionResponse);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}

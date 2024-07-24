package RK_coffe_shop_mapped_db.controller.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler<T> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    public ExceptionResponse<?> handle(Callable<T> callable) {
//        try {
//            T result = callable.call();
//            logger.info("operation succes");
//            return new ExceptionResponse<>(200, "Success", result);
//        } catch (Exception exception) {
//            logger.info("operation fatal");
//            return new ExceptionResponse<>(500, exception.getMessage(), exception);
//        }
//    }

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<ExceptionResponse<T>> handle(RuntimeException exception) {
        var exceptionResponse = new ExceptionResponse<T>(exception, exception.getMessage());
        logger.error("Api exception: {}", exceptionResponse);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}

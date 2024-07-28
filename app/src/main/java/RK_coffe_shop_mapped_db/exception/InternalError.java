package RK_coffe_shop_mapped_db.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InternalError extends RuntimeException {
    private final HttpStatus response = HttpStatus.BAD_REQUEST;

    public InternalError(String message) {
        super(message);
    }
}

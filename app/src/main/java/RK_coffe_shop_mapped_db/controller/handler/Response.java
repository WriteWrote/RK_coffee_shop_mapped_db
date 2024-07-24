package RK_coffe_shop_mapped_db.controller.handler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
@RequiredArgsConstructor
public class Response<T> {
    private Throwable throwable;
    private HttpStatus httpStatus;
    private String message;
    private T requestArgs;    //arguments
}

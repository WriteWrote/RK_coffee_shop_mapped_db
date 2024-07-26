package RK_coffe_shop_mapped_db.controller.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
    private Throwable throwable;
    private String message;
}
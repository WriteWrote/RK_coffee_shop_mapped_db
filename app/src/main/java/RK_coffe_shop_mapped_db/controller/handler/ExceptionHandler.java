package RK_coffe_shop_mapped_db.controller.handler;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;

@Component
@NoArgsConstructor
public class ExceptionHandler<T> {
	public Response<?> handle(Callable<T> callable) {
		try {
			T result = callable.call();
			return new Response<>(200, "Success", result);
		} catch (Exception exception) {
			return new Response<>(500, exception.getMessage(), exception);
		}
	}
}

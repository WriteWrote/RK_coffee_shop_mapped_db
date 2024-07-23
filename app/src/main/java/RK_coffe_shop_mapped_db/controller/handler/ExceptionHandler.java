package RK_coffe_shop_mapped_db.controller.handler;

import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;

@Component
@NoArgsConstructor
public class ExceptionHandler<T> {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	public Response<?> handle(Callable<T> callable) {
		try {
			T result = callable.call();
			logger.info("operation succes");
			return new Response<>(200, "Success", result);
		} catch (Exception exception) {
			logger.info("operation fatal");
			return new Response<>(500, exception.getMessage(), exception);
		}
	}
}

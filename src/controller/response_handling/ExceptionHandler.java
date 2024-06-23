package controller.response_handling;

import java.util.concurrent.Callable;

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

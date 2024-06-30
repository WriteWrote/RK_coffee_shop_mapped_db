package RK_coffe_shop_mapped_db.controller.handler;

public class Response<T> {
	private final Integer code;
	private final String message;
	private final T dto;
	
	public Response(Integer code, String message, T body) {
		this.code = code;
		this.message = message;
		this.dto = body;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public T getDto() {
		return dto;
	}
	
	@Override
	public String toString() {
		return "Response{" +
				"code=" + code +
				", message='" + message + '\'' +
				", dto=" + dto +
				'}';
	}
}

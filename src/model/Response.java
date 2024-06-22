package model;

public class Response<T> {
	private final Integer code;
	private final String message;
	private final T dto;
	
	public Response(Integer code, String message, T dto) {
		this.code = code;
		this.message = message;
		this.dto = dto;
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
}

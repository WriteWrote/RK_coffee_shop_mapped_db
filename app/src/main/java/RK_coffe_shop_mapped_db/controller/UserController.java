package RK_coffe_shop_mapped_db.controller;



import RK_coffe_shop_mapped_db.controller.handler.ExceptionHandler;
import RK_coffe_shop_mapped_db.controller.handler.Response;
import RK_coffe_shop_mapped_db.dto.CreateUserDto;
import RK_coffe_shop_mapped_db.dto.UserDto;
import RK_coffe_shop_mapped_db.service.UserService;

import java.util.List;
import java.util.UUID;

public class UserController {
	private final UserService service;
	private final ExceptionHandler<UserDto> handler;
	
	public UserController(UserService service, ExceptionHandler<UserDto> handler) {
		this.service = service;
		this.handler = handler;
	}
	
	public Response<?> create(CreateUserDto dto) {
		return handler.handle(() -> service.create(dto));
	}
	
	public Response<?> delete(UUID uuid) {
		return handler.handle(() -> {
			service.delete(uuid);
			return null;
		});
	}
	
	public Response<?> update(CreateUserDto dto) {
		return handler.handle(() -> service.update(dto));
	}
	
	public Response<?> getById(UUID uuid) {
		return handler.handle(() -> service.getById(uuid));
	}
	
	public Response<?> getAll() {
		return new ExceptionHandler<List<UserDto>>().handle(service::getAll);
	}
}

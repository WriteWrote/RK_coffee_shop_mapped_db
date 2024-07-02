package RK_coffe_shop_mapped_db.controller;


import RK_coffe_shop_mapped_db.controller.handler.ExceptionHandler;
import RK_coffe_shop_mapped_db.controller.handler.Response;
import RK_coffe_shop_mapped_db.dto.CreateUserDto;
import RK_coffe_shop_mapped_db.dto.UserDto;
import RK_coffe_shop_mapped_db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
	private final UserService service;
	private final ExceptionHandler<UserDto> handler;
	
	@Autowired
	public UserController(UserService service, ExceptionHandler<UserDto> handler) {
		this.service = service;
		this.handler = handler;
	}
	
	@PostMapping("/create")
	public Response<?> create(@RequestBody CreateUserDto dto) {
		return handler.handle(() -> service.create(dto));
	}
	
	@DeleteMapping("/delete/{uuid}")
	public Response<?> delete(@RequestParam("uuid") UUID uuid) {
		return handler.handle(() -> {
			service.delete(uuid);
			return null;
		});
	}
	
	@PutMapping("/update")
	public Response<?> update(@RequestBody CreateUserDto dto) {
		return handler.handle(() -> service.update(dto));
	}
	
	@GetMapping("/{uuid}")
	public Response<?> getById(@RequestParam("uuid") UUID uuid) {
		return handler.handle(() -> service.getById(uuid));
	}
	
	@GetMapping("/all")
	public Response<?> getAll() {
		return new ExceptionHandler<List<UserDto>>().handle(service::getAll);
	}
}

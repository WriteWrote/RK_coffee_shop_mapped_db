package RK_coffe_shop_mapped_db.controller;


import RK_coffe_shop_mapped_db.controller.handler.ExceptionHandler;
import RK_coffe_shop_mapped_db.controller.handler.Response;
import RK_coffe_shop_mapped_db.dto.RequestUserDto;
import RK_coffe_shop_mapped_db.dto.ResponseUserDto;
import RK_coffe_shop_mapped_db.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
	private final UserService userService;
	private final ExceptionHandler<ResponseUserDto> responseExceptionHandler;
	private final ExceptionHandler<RequestUserDto> requestExceptionHandler;
	
	@PostMapping
	public Response<?> create(@RequestBody RequestUserDto dto) {
		return requestExceptionHandler.handle(() -> userService.create(dto));
	}
	
	@DeleteMapping("/{id}")
	public Response<?> delete(@PathVariable("id") UUID id) {
		return responseExceptionHandler.handle(() -> {
			userService.delete(id);
			return null;
		});
	}
	
	@PutMapping
	public Response<?> update(@RequestBody RequestUserDto dto) {
		return requestExceptionHandler.handle(() -> userService.update(dto));
	}
	
	@GetMapping("/{id}")
	public Response<?> getById(@PathVariable("id") UUID id) {
		return responseExceptionHandler.handle(() -> userService.getById(id));
	}
	
	@GetMapping("/all")
	public Response<?> getAll() {
		return new ExceptionHandler<List<ResponseUserDto>>().handle(userService::getAll);
	}
}

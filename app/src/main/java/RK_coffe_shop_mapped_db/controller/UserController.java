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
	private final UserService service;
	private final ExceptionHandler<ResponseUserDto> handler;
	
	@PostMapping
	public Response<?> create(@RequestBody RequestUserDto dto) {
		return handler.handle(() -> service.create(dto));
	}
	
	@DeleteMapping("/{uuid}")
	public Response<?> delete(@PathVariable("uuid") UUID uuid) {
		return handler.handle(() -> {
			service.delete(uuid);
			return null;
		});
	}
	
	//fixme Create != Update dto
	@PutMapping
	public Response<?> update(@RequestBody RequestUserDto dto) {
		return handler.handle(() -> service.update(dto));
	}
	
	@GetMapping("/{uuid}")
	public Response<?> getById(@PathVariable("uuid") UUID uuid) {
		return handler.handle(() -> service.getById(uuid));
	}
	
	@GetMapping("/all")
	public Response<?> getAll() {
		return new ExceptionHandler<List<ResponseUserDto>>().handle(service::getAll);
	}
}

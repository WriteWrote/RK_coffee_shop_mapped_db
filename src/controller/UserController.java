package controller;

import controller.response_handling.ExceptionHandler;
import model.dto.CreateUserDto;
import model.dto.UserDto;
import service.UserService;

import java.util.List;
import java.util.UUID;

public class UserController {
	private final UserService service;
	private final ExceptionHandler<UserDto> handler;
	
	public UserController(UserService service, ExceptionHandler<UserDto> handler) {
		this.service = service;
		this.handler = handler;
	}
	
	public void create(CreateUserDto dto) {
		System.out.println(handler.handle(() -> service.create(dto)));
	}
	
	public void delete(UUID uuid) {
		System.out.println(handler.handle(() -> {
			service.delete(uuid);
			return null;
		}));
	}
	
	public void update(CreateUserDto dto) {
		System.out.println(handler.handle(() -> service.update(dto)));
	}
	
	public void getById(UUID uuid) {
		System.out.println(handler.handle(() -> service.getById(uuid)));
	}
	
	public void getAll() {
		System.out.println(new ExceptionHandler<List<UserDto>>().handle(service::getAll));
	}
}

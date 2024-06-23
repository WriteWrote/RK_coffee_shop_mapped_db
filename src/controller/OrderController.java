package controller;

import controller.response_handling.ExceptionHandler;
import model.dto.OrderDto;
import service.OrderService;

import java.util.List;
import java.util.UUID;

public class OrderController {
	private final OrderService service;
	private final ExceptionHandler<OrderDto> handler;
	
	public OrderController(OrderService service, ExceptionHandler<OrderDto> handler) {
		this.service = service;
		this.handler = handler;
	}
	
	public void create(OrderDto dto) { System.out.println(handler.handle(() -> service.create(dto))); }
	
	public void delete(UUID uuid) {
		System.out.println(handler.handle(() -> {
			service.delete(uuid);
			return null;
		}));
	}
	
	public void update(OrderDto dto) { System.out.println(handler.handle(() -> service.update(dto))); }
	
	public void getById(UUID uuid) { System.out.println(handler.handle(() -> service.getById(uuid))); }
	
	public void getAll() { System.out.println(new ExceptionHandler<List<OrderDto>>().handle(service::getAll)); }
}

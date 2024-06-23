package controller;

import controller.handler.ExceptionHandler;
import controller.handler.Response;
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
	
	public Response<?> create(OrderDto dto) {
		return handler.handle(() -> service.create(dto));
	}
	
	public Response<?> delete(UUID uuid) {
		return handler.handle(() -> {
			service.delete(uuid);
			return null;
		});
	}
	
	public Response<?> update(OrderDto dto) {
		return handler.handle(() -> service.update(dto));
	}
	
	public Response<?> getById(UUID uuid) {
		return handler.handle(() -> service.getById(uuid));
	}
	
	public Response<?> getAll() {
		return new ExceptionHandler<List<OrderDto>>().handle(service::getAll);
	}
}

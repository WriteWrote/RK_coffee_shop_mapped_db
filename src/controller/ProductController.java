package controller;

import controller.response_handling.ExceptionHandler;
import model.dto.ProductDto;
import service.ProductService;

import java.util.List;
import java.util.UUID;

public class ProductController {
	private final ProductService service;
	private final ExceptionHandler<ProductDto> handler;
	
	public ProductController(ProductService service, ExceptionHandler<ProductDto> handler) {
		this.service = service;
		this.handler = handler;
	}
	
	public void create(ProductDto dto) {
		System.out.println(handler.handle(() -> service.create(dto)));
		//todo toString
		//todo and for entity too
	}
	
	public void delete(UUID uuid) {
		System.out.println(handler.handle(() -> {
			service.delete(uuid);
			return null;
		}));
	}
	
	public void update(ProductDto dto) {
		System.out.println(handler.handle(() -> service.update(dto)));
	}
	
	public void getById(UUID uuid) {
		System.out.println(handler.handle(() -> service.getById(uuid)));
	}
	
	public void getAll() {
		System.out.println(new ExceptionHandler<List<ProductDto>>().handle(service::getAll));
	}
}

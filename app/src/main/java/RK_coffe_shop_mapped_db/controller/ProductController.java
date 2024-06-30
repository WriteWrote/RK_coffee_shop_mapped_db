package RK_coffe_shop_mapped_db.controller;

import RK_coffe_shop_mapped_db.controller.handler.ExceptionHandler;
import RK_coffe_shop_mapped_db.controller.handler.Response;
import RK_coffe_shop_mapped_db.dto.ProductDto;
import RK_coffe_shop_mapped_db.service.ProductService;

import java.util.List;
import java.util.UUID;

public class ProductController {
	private final ProductService service;
	private final ExceptionHandler<ProductDto> handler;
	
	public ProductController(ProductService service, ExceptionHandler<ProductDto> handler) {
		this.service = service;
		this.handler = handler;
	}
	
	public Response<?> create(ProductDto dto) {
		return handler.handle(() -> service.create(dto));
	}
	
	public Response<?> delete(UUID uuid) {
		return handler.handle(() -> {
			service.delete(uuid);
			return null;
		});
	}
	
	public Response<?> update(ProductDto dto) {
		return handler.handle(() -> service.update(dto));
	}
	
	public Response<?> getById(UUID uuid) {
		return handler.handle(() -> service.getById(uuid));
	}
	
	public Response<?> getAll() {
		return new ExceptionHandler<List<ProductDto>>().handle(service::getAll);
	}
}

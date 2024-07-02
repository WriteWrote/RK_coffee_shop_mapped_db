package RK_coffe_shop_mapped_db.controller;

import RK_coffe_shop_mapped_db.controller.handler.ExceptionHandler;
import RK_coffe_shop_mapped_db.controller.handler.Response;
import RK_coffe_shop_mapped_db.dto.ProductDto;
import RK_coffe_shop_mapped_db.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
	private final ProductService service;
	private final ExceptionHandler<ProductDto> handler;
	
	@Autowired
	public ProductController(ProductService service, ExceptionHandler<ProductDto> handler) {
		this.service = service;
		this.handler = handler;
	}
	
	@PostMapping("/create")
	public Response<?> create(@RequestBody ProductDto dto) {
		return handler.handle(() -> service.create(dto));
	}
	
	public Response<?> delete(UUID uuid) {
		return handler.handle(() -> {
			service.delete(uuid);
			return null;
		});
	}
	
	@PutMapping("/update")
	public Response<?> update(@RequestBody ProductDto dto) {
		return handler.handle(() -> service.update(dto));
	}
	
	@GetMapping("/{uuid}")
	public Response<?> getById(@RequestParam("uuid") UUID uuid) {
		return handler.handle(() -> service.getById(uuid));
	}
	
	@GetMapping("/all")
	public Response<?> getAll() {
		return new ExceptionHandler<List<ProductDto>>().handle(service::getAll);
	}
}

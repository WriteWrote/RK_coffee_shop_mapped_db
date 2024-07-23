package RK_coffe_shop_mapped_db.controller;

import RK_coffe_shop_mapped_db.controller.handler.ExceptionHandler;
import RK_coffe_shop_mapped_db.controller.handler.Response;
import RK_coffe_shop_mapped_db.dto.ProductDto;
import RK_coffe_shop_mapped_db.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/products")
public class ProductController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final ProductService productService;
	private final ExceptionHandler<ProductDto> handler;
	
	@PostMapping
	public Response<?> create(@RequestBody ProductDto dto) {
		logger.info("{} POST: create {}", this.getClass(), dto);
		return handler.handle(() -> productService.create(dto));
	}
	
	@DeleteMapping("/{id}")
	public Response<?> delete(@PathVariable("id") UUID id) {
		logger.info("{} DELETE: delete {}", this.getClass(), id);
		return handler.handle(() -> {
			productService.delete(id);
			return null;
		});
	}

	@PutMapping
	public Response<?> update(@RequestBody ProductDto dto) {
		logger.info("{} PUT: update {}", this.getClass(), dto);
		return handler.handle(() -> productService.update(dto));
	}

	@GetMapping("/{id}")
	public Response<?> getById(@PathVariable("id") UUID id) {
		logger.info("{} GET: getById {}", this.getClass(), id);
		return handler.handle(() -> productService.getById(id));
	}

	@GetMapping("/all")
	public Response<?> getAll() {
		logger.info("{} GET: getAll", this.getClass());
		return new ExceptionHandler<List<ProductDto>>().handle(productService::getAll);
	}
}

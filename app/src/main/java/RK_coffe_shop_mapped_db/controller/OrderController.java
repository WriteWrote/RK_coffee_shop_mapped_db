package RK_coffe_shop_mapped_db.controller;

import RK_coffe_shop_mapped_db.controller.handler.ExceptionHandler;
import RK_coffe_shop_mapped_db.controller.handler.Response;
import RK_coffe_shop_mapped_db.dto.OrderDto;
import RK_coffe_shop_mapped_db.service.OrderService;
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
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
	private final OrderService orderService;
	private final ExceptionHandler<OrderDto> handler;

	@PostMapping
	public Response<?> create(@RequestBody OrderDto dto) {
		return handler.handle(() -> orderService.create(dto));
	}

//	@DeleteMapping("/{id}")
//	public Response<?> delete(@PathVariable("id") UUID id) {
//		return handler.handle(() -> {
//			orderService.delete(id);
//			return null;
//		});
//	}

	@PutMapping
	public Response<?> update(@RequestBody OrderDto dto) {
		return handler.handle(() -> orderService.update(dto));
	}

	@GetMapping("/{id}")
	public Response<?> getById(@PathVariable("id") UUID id) {
		return handler.handle(() -> orderService.getById(id));
	}

	@GetMapping("/all")
	public Response<?> getAll() {
		return new ExceptionHandler<List<OrderDto>>().handle(orderService::getAll);
	}
}

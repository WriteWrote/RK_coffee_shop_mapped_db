package RK_coffe_shop_mapped_db.controller;

import RK_coffe_shop_mapped_db.controller.handler.ExceptionHandler;
import RK_coffe_shop_mapped_db.controller.handler.Response;
import RK_coffe_shop_mapped_db.dto.OrderDto;
import RK_coffe_shop_mapped_db.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {
	private final OrderService service;
	private final ExceptionHandler<OrderDto> handler;
	
	@Autowired
	public OrderController(OrderService service, ExceptionHandler<OrderDto> handler) {
		this.service = service;
		this.handler = handler;
	}
	
	@PostMapping("/create")
	public Response<?> create(@RequestBody OrderDto dto) {
		return handler.handle(() -> service.create(dto));
	}
	
	@DeleteMapping("/delete/{uuid}")
	public Response<?> delete(@RequestParam("uuid") UUID uuid) {
		return handler.handle(() -> {
			service.delete(uuid);
			return null;
		});
	}
	
	@PutMapping("/update")
	public Response<?> update(@RequestBody OrderDto dto) {
		return handler.handle(() -> service.update(dto));
	}
	
	@GetMapping("/{uuid}")
	public Response<?> getById(@RequestParam("uuid") UUID uuid) {
		return handler.handle(() -> service.getById(uuid));
	}
	
	@GetMapping("/all")
	public Response<?> getAll() {
		return new ExceptionHandler<List<OrderDto>>().handle(service::getAll);
	}
}

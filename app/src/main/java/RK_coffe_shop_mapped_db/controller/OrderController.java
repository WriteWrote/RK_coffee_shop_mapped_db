package RK_coffe_shop_mapped_db.controller;

import RK_coffe_shop_mapped_db.controller.handler.ApiExceptionHandler;
import RK_coffe_shop_mapped_db.dto.OrderDto;
import RK_coffe_shop_mapped_db.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final OrderService orderService;
	private final ApiExceptionHandler handler;
	
	@PostMapping
	public ResponseEntity<OrderDto> create(@RequestBody OrderDto dto) {
		logger.info("{} POST: create {}", this.getClass(), dto);
		return new ResponseEntity<>(
			orderService.create(dto),
			HttpStatus.CREATED
		);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
		logger.info("{} DELETE: delete {}", this.getClass(), id);
		orderService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<OrderDto> update(@RequestBody OrderDto dto) {
		logger.info("{} PUT: update {}", this.getClass(), dto);
		return new ResponseEntity<>(
			orderService.update(dto),
			HttpStatus.OK
		);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderDto> getById(@PathVariable("id") UUID id) {
		logger.info("{} GET: getById {}", this.getClass(), id);
		return new ResponseEntity<>(
			orderService.getById(id),
			HttpStatus.OK
		);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<OrderDto>> getAll() {
		logger.info("{} GET: getAll", this.getClass());
		return new ResponseEntity<>(
			orderService.getAll(),
			HttpStatus.OK
		);
	}
}

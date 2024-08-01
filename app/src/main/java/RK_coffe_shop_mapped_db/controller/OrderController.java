package RK_coffe_shop_mapped_db.controller;

import RK_coffe_shop_mapped_db.dto.OrderDto;
import RK_coffe_shop_mapped_db.service.OrderService;
import lombok.RequiredArgsConstructor;
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
	private final OrderService orderService;
	
	@PostMapping
	public ResponseEntity<OrderDto> create(@RequestBody OrderDto dto) {
		return new ResponseEntity<>(
			orderService.create(dto),
			HttpStatus.CREATED
		);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
		orderService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<OrderDto> update(@RequestBody OrderDto dto) {
		return new ResponseEntity<>(
			orderService.update(dto),
			HttpStatus.OK
		);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderDto> getById(@PathVariable("id") UUID id) {
		return new ResponseEntity<>(
			orderService.getById(id),
			HttpStatus.OK
		);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<OrderDto>> getAll() {
		return new ResponseEntity<>(
			orderService.getAll(),
			HttpStatus.OK
		);
	}
}

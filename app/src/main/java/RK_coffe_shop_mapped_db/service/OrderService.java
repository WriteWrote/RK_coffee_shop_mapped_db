package RK_coffe_shop_mapped_db.service;

import RK_coffe_shop_mapped_db.db.entity.OrderEntity;
import RK_coffe_shop_mapped_db.db.entity.OrderLineEntity;
import RK_coffe_shop_mapped_db.db.repository.OrderLineRepository;
import RK_coffe_shop_mapped_db.db.repository.OrderRepository;
import RK_coffe_shop_mapped_db.dto.OrderDto;
import RK_coffe_shop_mapped_db.service.mapper.OrderLineMapper;
import RK_coffe_shop_mapped_db.service.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
	private final OrderRepository orderRepository;
	private final OrderLineRepository orderLineRepository;
	private final OrderLineMapper orderLineMapper;
	private final OrderMapper orderMapper;
	
	public OrderDto create(OrderDto dto) {
		if (dto.getId() == null)
			dto.setId(UUID.randomUUID());
		OrderDto savedDto = orderMapper.toDto(orderRepository.save(orderMapper.toEntity(dto)));
		List<OrderLineEntity> orderLines = orderLineMapper.toEntities(dto.getProducts(), savedDto.getId());
		orderLines.forEach(it -> {
			it.setId(UUID.randomUUID());
			orderLineRepository.save(it);
		});
		return savedDto;
	}
	
	public void delete(UUID id) throws Exception {
		if (!orderRepository.existsById(id)) {
			throw new Exception("No order to delete");
		}
		orderLineRepository.findOrderLineEntitiesByOrderId(id).forEach(it -> orderLineRepository.delete(it.getId()));
		orderRepository.delete(id);
	}
	
	/**
	 * Предполагается, что после создания содержимое заказа уже не может быть изменено,
	 * только поля получателя: Фио, адрес, статус заказа и т.д.
	 */
	public OrderDto update(OrderDto dto) throws Exception {
		if (!orderRepository.existsById(dto.getId())) {
			throw new Exception("No order to update");
		}
		return orderMapper.toDto(orderRepository.update(orderMapper.toEntity(dto)));
	}
	
	public OrderDto getById(UUID id) {
		Map<UUID, Integer> productsDto = orderLineMapper.fromEntities(orderLineRepository.findOrderLineEntitiesByOrderId(id));
		OrderDto dto = orderMapper.toDto(orderRepository.findById(id).orElseThrow());
		dto.setProducts(productsDto);
		return dto;
	}
	
	public List<OrderDto> getAll() {
		List<OrderDto> list = new ArrayList<>();
		for (OrderEntity it : orderRepository.findAll()) {
			OrderDto byId = this.getById(it.getId());
			list.add(byId);
		}
		return list;
	}
}

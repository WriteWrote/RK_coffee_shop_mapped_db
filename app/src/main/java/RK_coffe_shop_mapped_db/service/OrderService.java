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
	private final OrderMapper orderMapper;
	private final OrderLineMapper orderLineMapper;
	
	public OrderDto create(OrderDto dto) {
		OrderDto savedDto = orderMapper.fromEntity(orderRepository.save(orderMapper.toEntity(dto)));
		List<OrderLineEntity> orderLines = orderLineMapper.toEntities(dto.getProducts(), savedDto.getUuid());
		orderLineRepository.saveAll(orderLines);
		return savedDto;
	}
	
	public void delete(UUID uuid) throws Exception {
		if (!orderRepository.existsById(uuid)) {
			throw new Exception("No order to delete");
		}
		orderLineRepository.deleteAll(orderLineRepository.findOrderLineEntitiesByOrderId(uuid));
		orderRepository.deleteById(uuid);
	}
	
	/**
	 * Предполагается, что после создания содержимое заказа уже не может быть изменено,
	 * только поля получателя: Фио, адрес, статус заказа и т.д.
	 */
	public OrderDto update(OrderDto dto) throws Exception {
		if (!orderRepository.existsById(dto.getUuid())) {
			throw new Exception("No order to update");
		}
		return orderMapper.fromEntity(orderRepository.save(orderMapper.toEntity(dto)));
	}
	
	public OrderDto getById(UUID uuid) {
		Map<UUID, Integer> productsDto = orderLineMapper.fromEntities(orderLineRepository.findOrderLineEntitiesByOrderId(uuid));
		OrderDto dto = orderMapper.fromEntity(orderRepository.findById(uuid).orElseThrow());
		dto.setProducts(productsDto);
		return dto;
	}
	
	public List<OrderDto> getAll() {
		List<OrderDto> list = new ArrayList<>();
		for (OrderEntity it : orderRepository.findAll()) {
			OrderDto byId = this.getById(it.getUuid());
			list.add(byId);
		}
		return list;
	}
}

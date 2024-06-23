package service;

import db.entity.OrderEntity;
import db.entity.OrderLineEntity;
import db.repository.OrderLineRepository;
import db.repository.OrderRepository;
import model.dto.OrderDto;
import model.mapper.OrderLineMapper;
import model.mapper.OrderMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OrderService {
	private final OrderRepository orderRepository;
	private final OrderLineRepository orderLineRepository;
	private final OrderMapper orderMapper;
	private final OrderLineMapper orderLineMapper;
	
	public OrderService(OrderRepository orderRepository, OrderLineRepository orderLineRepository, OrderMapper orderMapper, OrderLineMapper orderLineMapper) {
		this.orderRepository = orderRepository;
		this.orderLineRepository = orderLineRepository;
		this.orderMapper = orderMapper;
		this.orderLineMapper = orderLineMapper;
	}
	
	public OrderDto create(OrderDto dto) {
		OrderDto savedDto = orderMapper.fromEntity(orderRepository.save(orderMapper.toEntity(dto)));
		List<OrderLineEntity> orderLines = orderLineMapper.toEntities(dto.getProducts(), dto.getUuid());
		orderLines.forEach(orderLineRepository::save);
		return dto;  //todo fix this
	}
	
	public void delete(UUID uuid) throws Exception {
		for (OrderLineEntity it : orderLineRepository.findAllByOrderId(uuid)) {
			orderLineRepository.delete(it.getUUID());
		}
		orderRepository.delete(uuid);
	}
	
	/**
	 * Предполагается, что после создания содержимое заказа уже не может быть изменено,
	 * только поля получателя: ФИО, адрес, статус заказа и т.д.
	 */
	public OrderDto update(OrderDto dto) throws Exception {
		orderRepository.update(orderMapper.toEntity(dto));
		return dto; //todo fix this
	}
	
	public OrderDto getById(UUID uuid) throws Exception {
		Map<UUID, Integer> productsDto = orderLineMapper.fromEntities(orderLineRepository.findAllByOrderId(uuid));
		OrderDto dto = orderMapper.fromEntity(orderRepository.findById(uuid));
		dto.setProducts(productsDto);
		return dto;
	}
	
	public List<OrderDto> getAll() throws Exception {
		List<OrderDto> list = new ArrayList<>();
		for (OrderEntity it : orderRepository.findAll()) {
			OrderDto byId = this.getById(it.getUUID());
			list.add(byId);
		}
		return list;
	}
}

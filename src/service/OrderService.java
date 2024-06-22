package service;

import db.repository.OrderLineRepository;
import db.repository.OrderRepository;
import model.dto.OrderDto;
import model.mapper.OrderLineMapper;
import model.mapper.OrderMapper;

import java.util.List;
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
	
	public OrderDto create(OrderDto dto){
	
	}
	
	public void delete(UUID uuid){
		//dont forget about orderlines
	}
	public OrderDto update(OrderDto dto){
	
	}
	
	public OrderDto getById(UUID uuid){
	
	}
	
	public List<OrderDto> getAll(){
	
	}
	
}

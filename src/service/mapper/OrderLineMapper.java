package service.mapper;

import db.entity.OrderLineEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class OrderLineMapper {
	public List<OrderLineEntity> toEntities(Map<UUID, Integer> dtos, UUID orderId) {
		return dtos.entrySet().stream().map(it -> new OrderLineEntity(
						UUID.randomUUID(),
						orderId,
						it.getKey(),
						it.getValue()
				)
		).collect(Collectors.toList());
	}
	
	public Map<UUID, Integer> fromEntities(List<OrderLineEntity> entities) {
		return entities.stream().collect(Collectors.toMap(OrderLineEntity::getProductId, OrderLineEntity::getQuantity));
	}
}

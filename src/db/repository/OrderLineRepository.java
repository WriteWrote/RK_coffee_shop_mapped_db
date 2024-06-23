package db.repository;

import db.entity.OrderLineEntity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class OrderLineRepository extends CommonCRUDRepository<OrderLineEntity> {
	public List<OrderLineEntity> findAllByOrderId(UUID orderId) {
		return this.getTable().values().stream()
				.filter(orderLineEntity -> orderLineEntity.getOrderId().equals(orderId))
				.collect(Collectors.toList());
	}
}

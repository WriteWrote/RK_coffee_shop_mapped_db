package RK_coffe_shop_mapped_db.db.repository;

import RK_coffe_shop_mapped_db.db.entity.OrderLineEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Repository
public class OrderLineRepository extends CommonCRUDRepository<OrderLineEntity> {
	public List<OrderLineEntity> findAllByOrderId(UUID orderId) {
		return this.getTable().values().stream()
				.filter(orderLineEntity -> orderLineEntity.getOrderId().equals(orderId))
				.collect(Collectors.toList());
	}
}

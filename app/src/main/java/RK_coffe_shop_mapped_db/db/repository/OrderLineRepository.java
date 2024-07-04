package RK_coffe_shop_mapped_db.db.repository;

import RK_coffe_shop_mapped_db.db.entity.OrderLineEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public interface OrderLineRepository extends CrudRepository<OrderLineEntity, UUID> {
	//todo fix implementation
//	public List<OrderLineEntity> findAllByOrderId(UUID orderId) {
//		return this.getTable().values().stream()
//				.filter(orderLineEntity -> orderLineEntity.getOrderId().equals(orderId))
//				.collect(Collectors.toList());
//	}
}

package RK_coffe_shop_mapped_db.db.repository;

import RK_coffe_shop_mapped_db.db.entity.OrderLineEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface OrderLineRepository extends CrudRepository<OrderLineEntity, UUID> {
	List<OrderLineEntity> findOrderLineEntitiesByOrderId(UUID orderId);
}

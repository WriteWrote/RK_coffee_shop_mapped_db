package RK_coffe_shop_mapped_db.db.repository;

import RK_coffe_shop_mapped_db.db.entity.OrderLineEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class OrderLineRepository extends CommonCrudRepository<OrderLineEntity, UUID> {
	@Autowired
	public OrderLineRepository(JdbcTemplate jdbcTemplate) {
		super("orders_lines", jdbcTemplate);
	}
	
	List<OrderLineEntity> findOrderLineEntitiesByOrderId(UUID orderId) {
		//todo not yet implemented
		return null;
	}
}

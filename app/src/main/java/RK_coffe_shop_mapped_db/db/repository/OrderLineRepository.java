package RK_coffe_shop_mapped_db.db.repository;

import RK_coffe_shop_mapped_db.db.entity.OrderLineEntity;
import RK_coffe_shop_mapped_db.db.repository.rowmapper.OrderLineRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class OrderLineRepository extends CommonCrudRepository<OrderLineEntity, UUID> {
	@Autowired
	public OrderLineRepository(JdbcTemplate jdbcTemplate, OrderLineRowMapper orderLineRowMapper) {
		super("orders_lines", jdbcTemplate, orderLineRowMapper);
	}
	
	public List<OrderLineEntity> findOrderLineEntitiesByOrderId(UUID orderId) {
		return findAll().stream().filter(it -> it.getOrderId().equals(orderId)).collect(Collectors.toList());
	}
}

package RK_coffe_shop_mapped_db.db.repository;

import RK_coffe_shop_mapped_db.db.entity.OrderEntity;
import RK_coffe_shop_mapped_db.db.repository.rowmapper.OrderRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class OrderRepository extends CommonCrudRepository<OrderEntity, UUID> {
	@Autowired
	public OrderRepository(JdbcTemplate jdbcTemplate, OrderRowMapper orderRowMapper) {
		super("order", jdbcTemplate, orderRowMapper);
	}
}

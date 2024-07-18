package RK_coffe_shop_mapped_db.db.repository.rowmapper;

import RK_coffe_shop_mapped_db.db.entity.OrderLineEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class OrderLineRowMapper implements RowMapper<OrderLineEntity> {
	@Override
	public OrderLineEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		return new OrderLineEntity(
			UUID.fromString(resultSet.getString("id")),
			UUID.fromString(resultSet.getString("order_id")),
			UUID.fromString(resultSet.getString("product_id")),
			resultSet.getInt("quantity")
		);
	}
}

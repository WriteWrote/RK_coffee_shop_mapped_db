package RK_coffe_shop_mapped_db.db.repository.rowmapper;

import RK_coffe_shop_mapped_db.db.entity.OrderEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


@Component
public class OrderRowMapper implements RowMapper<OrderEntity> {
	@Override
	public OrderEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		return new OrderEntity(
			UUID.fromString(resultSet.getString("id")),
			UUID.fromString(resultSet.getString("customer_id")),    //todo hazardous
			resultSet.getString("customer_phone"),
			resultSet.getString("customer_fio"),
			resultSet.getString("address"),
			resultSet.getString("status")
		);
	}
}

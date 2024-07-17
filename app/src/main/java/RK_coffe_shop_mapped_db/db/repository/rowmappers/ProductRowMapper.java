package RK_coffe_shop_mapped_db.db.repository.rowmappers;

import RK_coffe_shop_mapped_db.db.entity.ProductEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class ProductRowMapper implements RowMapper<ProductEntity> {
	@Override
	public ProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new ProductEntity(
			UUID.fromString(rs.getString("id")),
			rs.getString("title"),
			rs.getString("description")
		);
	}
}

package RK_coffe_shop_mapped_db.db.repository.rawmappers;

import RK_coffe_shop_mapped_db.db.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Mapper
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

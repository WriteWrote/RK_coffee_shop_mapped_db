package RK_coffe_shop_mapped_db.db.repository;

import RK_coffe_shop_mapped_db.db.entity.ProductEntity;
import RK_coffe_shop_mapped_db.db.repository.rawmappers.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ProductRepository extends CommonCrudRepository<ProductEntity, UUID> {
	@Autowired
	public ProductRepository(JdbcTemplate jdbcTemplate, ProductRowMapper productRowMapper) {
		super("products", jdbcTemplate, productRowMapper);
	}
}

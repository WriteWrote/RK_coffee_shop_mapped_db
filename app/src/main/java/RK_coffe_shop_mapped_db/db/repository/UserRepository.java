package RK_coffe_shop_mapped_db.db.repository;


import RK_coffe_shop_mapped_db.db.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserRepository extends CommonCrudRepository<UserEntity, UUID> {
	@Autowired
	public UserRepository(JdbcTemplate jdbcTemplate){
		super("users", jdbcTemplate);
	}
}

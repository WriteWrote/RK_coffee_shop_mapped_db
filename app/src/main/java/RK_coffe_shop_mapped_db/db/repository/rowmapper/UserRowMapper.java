package RK_coffe_shop_mapped_db.db.repository.rowmapper;

import RK_coffe_shop_mapped_db.db.entity.UserEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class UserRowMapper implements RowMapper<UserEntity> {
	@Override
	public UserEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		return new UserEntity(
			UUID.fromString(resultSet.getString("id")),
			resultSet.getString("login"),
			resultSet.getString("password")
		);
	}
}

package RK_coffe_shop_mapped_db.db.repository.rowmapper;

import RK_coffe_shop_mapped_db.db.entity.FileMetadataEntity;
import RK_coffe_shop_mapped_db.db.entity.ProductEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class FileMetadataRowMapper implements RowMapper<FileMetadataEntity> {
	@Override
	public FileMetadataEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		return new FileMetadataEntity(
			UUID.fromString(resultSet.getString("id")),
			resultSet.getString("filepath"),
			resultSet.getString("file_extension")
		);
	}
}

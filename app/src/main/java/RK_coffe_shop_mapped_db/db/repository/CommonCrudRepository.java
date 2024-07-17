package RK_coffe_shop_mapped_db.db.repository;

import com.google.common.base.CaseFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public abstract class CommonCrudRepository<T, ID> {    //todo think about marker interface Entity maybe
	@Value("${db.schema}")
	private String schemaName;
	
	private final String tableName;
	private final JdbcTemplate jdbcTemplate;
	
	public <E extends T> E save(E object) {
		StringBuilder sqlBuilder = new StringBuilder();
		List<Field> fields = Arrays.stream(object.getClass().getDeclaredFields()).toList();
		Object[] values = fields.stream().map(it -> {
			try {
				var getterName = "get" + CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, it.getName());
				return object.getClass().getMethod(getterName).invoke(object);
			} catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
				throw new RuntimeException(e);
			}
		}).toArray(Object[]::new);
		
		sqlBuilder
			.append("INSERT INTO ")
			.append(schemaName)
			.append(".")
			.append(tableName)
			.append("(");
		
		fields.forEach(it -> {
			sqlBuilder.append(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, it.getName()));
			sqlBuilder.append(",");
		});
		
		sqlBuilder.deleteCharAt(sqlBuilder.length() - 1);
		
		sqlBuilder.append(") ");
		sqlBuilder.append("values");
		sqlBuilder.append("(");
		
		fields.forEach(it -> sqlBuilder.append("?,"));
		
		sqlBuilder.deleteCharAt(sqlBuilder.length() - 1);
		
		sqlBuilder.append(");");
		
		jdbcTemplate.update(sqlBuilder.toString(), values);
		return object;    //todo think about it
	}
	
	public void delete(UUID id) throws Exception {
		StringBuilder sqlBuilder = new StringBuilder();
		
		sqlBuilder
			.append("DELETE FROM ")
			.append(schemaName)
			.append(".")
			.append(tableName)
			.append(" WHERE id = ?;")
		;
		
		jdbcTemplate.update(sqlBuilder.toString(), id);
	}

//	public <E extends T> E update(E object) throws Exception {
//		if (table.containsKey(object.getId()))
//			return table.put(object.getId(), object);
//		else throw new Exception("No element with this UUID in table");
//		return null;
	//todo not yet implemented
//	}
	
	public <E extends T> E findById(UUID id) throws Exception {
		StringBuilder sqlBuilder = new StringBuilder();
		
		sqlBuilder
			.append("SELECT * FROM ")
			.append(schemaName)
			.append(".")
			.append(tableName)
			.append(" WHERE id = ?;")
		;

//		if (table.containsKey(uuid))
//			return table.get(uuid);
//		else throw new Exception("No element with this UUID in table");
		jdbcTemplate.query(sqlBuilder .toString(), (resultSet, i) -> {
		});
		//todo not yet implemented
	}
	
	public <E extends T> Collection<E> findAll() {
		StringBuilder sqlBuilder = new StringBuilder();
		
		sqlBuilder
			.append("SELECT * FROM ")
			.append(schemaName)
			.append(".")
			.append(tableName)
			.append(";");    //todo should i use LIMIT?

//		return jdbcTemplate.query(sqlBuilder.toString(), (resultSet, i) -> {
//			return new Object();
//			resultSet.getString("");
//		});//todo not yet implemented
		return null;
	}
}

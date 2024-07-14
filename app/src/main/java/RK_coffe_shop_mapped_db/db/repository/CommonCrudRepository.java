package RK_coffe_shop_mapped_db.db.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Field;
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
		
		sqlBuilder
			.append("INSERT INTO ")
			.append(schemaName)
			.append(".")
			.append(tableName)
			.append("(");
		
		fields.forEach(it -> {
			sqlBuilder.append(it);
			sqlBuilder.append(", ");
		});
		
		sqlBuilder.append(") ");
		sqlBuilder.append("values");
		sqlBuilder.append("(");
		sqlBuilder.append("gen_random_uuid(), ");
		
		fields.forEach(it -> {
			try {
				it.setAccessible(true);
				sqlBuilder.append(it.get(object));
				sqlBuilder.append(", ");
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} finally {
				it.setAccessible(false);
			}
		});
		
		sqlBuilder.append(");");
		
		/*
		 * insert into rk_coffee_shop.products(uuid, title, description) values (gen_random_uuid(), 'title','description');
		 */
		
		jdbcTemplate.update(sqlBuilder.toString());
		return object;    //todo think about it
	}
	
	public void delete(UUID id) throws Exception {
//		if (table.containsKey(uuid)){
//			//todo not yet implemented
//		}
//		else throw new Exception("No element with this UUID in table");
	}
	
	public <E extends T> E update(E object) throws Exception {
//		if (table.containsKey(object.getId()))
//			return table.put(object.getId(), object);
//		else throw new Exception("No element with this UUID in table");
		return null;
		//todo not yet implemented
	}
	
	public <E extends T> E findById(UUID id) throws Exception {
//		if (table.containsKey(uuid))
//			return table.get(uuid);
//		else throw new Exception("No element with this UUID in table");
		return null;
		//todo not yet implemented
	}
	
	public <E extends T> Collection<E> findAll() {
//		return table.values();
		return null;
		//todo not yet implemented
	}
}

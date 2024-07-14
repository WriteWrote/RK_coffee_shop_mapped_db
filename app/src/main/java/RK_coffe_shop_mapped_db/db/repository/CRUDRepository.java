package RK_coffe_shop_mapped_db.db.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public abstract class CRUDRepository<T, ID> {    //todo think about functional interface Entity maybe
	private JdbcTemplate jdbcTemplate;
	
	public <E extends T> E save(E object, String schema, String name) {
		StringBuilder sqlBuilder = new StringBuilder();
		List<Field> fields = Arrays.stream(object.getClass().getDeclaredFields()).toList();
		
		sqlBuilder
			.append("INSERT INTO ")
			.append(schema)
			.append(".")
			.append(name)
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
		return null;
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

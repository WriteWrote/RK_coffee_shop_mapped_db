package RK_coffe_shop_mapped_db.db.entity;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class Entity {
	private UUID uuid;
	
	public Entity(UUID uuid) {
		this.uuid = uuid;
	}
	
	public UUID getUUID() {
		return uuid;
	}
	
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	
	@Override
	public String toString() {
		List<Field> fields = Arrays.stream(this.getClass().getDeclaredFields()).toList();
		AtomicReference<String> result = new AtomicReference<>("Entity { uuid: " + this.uuid + "; ");
		fields.forEach(it -> {
			try {
				it.setAccessible(true);
				result.set(result + it.getName() + ": " + it.get(this) + "; ");
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} finally {
				it.setAccessible(false);
			}
		});
		return result + "}";
	}
}

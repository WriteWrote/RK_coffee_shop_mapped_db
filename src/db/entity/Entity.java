package db.entity;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Entity {
	private UUID id;
	
	public Entity(UUID id) {
		this.id = id;
	}
	
	public UUID getUUID() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		List<Field> fields = Arrays.stream(this.getClass().getDeclaredFields()).collect(Collectors.toList());
		AtomicReference<String> result = new AtomicReference<>("Entity { uuid: " + this.id + "; ");
		fields.forEach(it -> {
			try {
				it.setAccessible(true);
				result.set(result + it.getName() + ": " + it.get(this) + "; ");
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		});
		return result + "}";
	}
}

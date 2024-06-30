package RK_coffe_shop_mapped_db.db.repository;

import RK_coffe_shop_mapped_db.db.entity.Entity;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public abstract class CommonCRUDRepository<T extends Entity> {
	private Map<UUID, T> table;
	
	public void setTable(Map<UUID, T> table) {
		this.table = table;
	}
	
	public Map<UUID, T> getTable() {
		return table;
	}
	
	public T save(T object) {
		if (object.getUUID() == null) {
			object.setUuid(UUID.randomUUID());
		}
		table.put(object.getUUID(), object);
		return table.get(object.getUUID());
	}
	
	public T delete(UUID uuid) throws Exception {
		if (table.containsKey(uuid))
			return table.remove(uuid);
		else throw new Exception("No element with this UUID in table");
	}
	
	public T update(T object) throws Exception {
		if (table.containsKey(object.getUUID()))
			return table.put(object.getUUID(), object);
		else throw new Exception("No element with this UUID in table");
	}
	
	public T findById(UUID uuid) throws Exception {
		if (table.containsKey(uuid))
			return table.get(uuid);
		else throw new Exception("No element with this UUID in table");
	}
	
	public Collection<T> findAll() {
		return table.values();
	}
}

package RK_coffe_shop_mapped_db.db.repository;

import java.util.Collection;
import java.util.UUID;

public abstract class CRUDRepository<T> {    //todo think about functional interface Entity maybe
	public T save(T object) {
		//todo not yet implemented
		return null;
	}
	
	public void delete(UUID id) throws Exception {
//		if (table.containsKey(uuid)){
//			//todo not yet implemented
//		}
//		else throw new Exception("No element with this UUID in table");
	}
	public T update(T object) throws Exception {
//		if (table.containsKey(object.getId()))
//			return table.put(object.getId(), object);
//		else throw new Exception("No element with this UUID in table");
		return null;
		//todo not yet implemented
	}
	
	public T findById(UUID uuid) throws Exception {
//		if (table.containsKey(uuid))
//			return table.get(uuid);
//		else throw new Exception("No element with this UUID in table");
		return null;
		//todo not yet implemented
	}
	
	public Collection<T> findAll() {
//		return table.values();
		return null;
		//todo not yet implemented
	}
}

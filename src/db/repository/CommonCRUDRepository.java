package db.repository;

import db.entity.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public abstract class CommonCRUDRepository<T extends Entity> {
	private Map<UUID, T> table;
	public T save(T object) {
		
		//todo shove it in map
		//todo create parent Entity class
		return object;
	}
	
	public void delete() {
	
	}
	
	public T update(T object) {
		/**
		 * rewrite by uuid value in map
		 */
		return (T) new Object();
	}
	
	public T findById(UUID id) {
		return (T) new Object();
	}
	
	public List<T> findAll() {
		return new ArrayList<T>();
	}
}

package db.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class CommonCRUDRepository<T> {
	/**
	 * CRUD repository
	 * create
	 * delete
	 * update
	 * findById
	 * findAll
	 */
	public T save(T object) {
		//todo shove it in map
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

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
	public T create() {
		return (T) new Object();    //there goes reflection?
	}
	
	public void delete() {
	
	}
	
	public T update() {
		return (T) new Object();
	}
	
	public T findById(UUID id) {
		return (T) new Object();
	}
	
	public List<T> findAll() {
		return new ArrayList<T>();
	}
}

package db.entity;

import java.util.UUID;

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
}

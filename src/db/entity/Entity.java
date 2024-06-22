package db.entity;

import java.util.UUID;

public class Entity {
	private UUID id;
	
	public UUID getUUID() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
}

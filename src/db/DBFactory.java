package db;

import db.entity.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DBFactory<T extends Entity> {
	public Map<UUID, T> initEmptyTable() {
		return new HashMap<>();
	}
}

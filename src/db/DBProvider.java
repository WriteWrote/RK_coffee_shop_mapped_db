package db;

import db.entity.Entity;

import java.util.*;

public class DBProvider<T extends Entity> {
	public Map<UUID, T> initEmptyTable() {
		return new HashMap<>();
	}
}

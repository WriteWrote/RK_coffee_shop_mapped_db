package db.entity;

import java.util.UUID;

public class UserEntity extends Entity {
	private final String login;
	private String password;
	
	public UserEntity(UUID uuid, String login, String password) {
		super(uuid);
		this.login = login;
		this.password = password;
	}
	
	public UserEntity(UUID uuid,String login) {
		super(uuid);
		this.login = login;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getPassword() {
		return password;
	}
}

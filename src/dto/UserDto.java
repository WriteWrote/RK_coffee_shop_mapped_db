package dto;

import java.util.UUID;

public class UserDto {
	private final UUID uuid;
	private final String login;
	
	public UserDto(UUID uuid, String login) {
		this.uuid = uuid;
		this.login = login;
	}
	
	public UUID getUuid() {
		return uuid;
	}
	
	public String getLogin() {
		return login;
	}
}

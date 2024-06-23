package model.dto;

import java.util.UUID;

public class CreateUserDto extends UserDto {
	private final String password;
	
	public CreateUserDto(UUID uuid, String login, String password) {
		super(uuid, login);
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
}

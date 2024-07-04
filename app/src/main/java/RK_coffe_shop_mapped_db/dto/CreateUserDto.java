package RK_coffe_shop_mapped_db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
public class CreateUserDto extends UserDto {
	private String password;
	
	public CreateUserDto(UUID uuid, String login, String password) {
		super(uuid, login);
		this.password = password;
	}
}

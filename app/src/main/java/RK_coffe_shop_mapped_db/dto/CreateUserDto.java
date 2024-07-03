package RK_coffe_shop_mapped_db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class CreateUserDto extends UserDto {
	private String password;
	
	public String getPassword() {
		return password;
	}
}

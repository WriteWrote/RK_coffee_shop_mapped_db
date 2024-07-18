package RK_coffe_shop_mapped_db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class RequestUserDto {
	@Setter
	private UUID id;
	private String login;
	private String password;
}

package RK_coffe_shop_mapped_db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@AllArgsConstructor
public class RequestUserDto {
	@Setter
	private UUID id;
	private String login;
	private String password;
}

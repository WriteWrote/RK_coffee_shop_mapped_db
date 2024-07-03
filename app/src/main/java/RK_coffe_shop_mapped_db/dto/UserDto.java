package RK_coffe_shop_mapped_db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;
@RequiredArgsConstructor
@Getter
public class UserDto {
	private UUID uuid;
	private String login;
}

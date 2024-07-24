package RK_coffe_shop_mapped_db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@AllArgsConstructor
public class ResponseUserDto {
	private UUID id;
	private String login;
}

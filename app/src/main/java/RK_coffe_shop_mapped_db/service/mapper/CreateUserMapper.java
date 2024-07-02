package RK_coffe_shop_mapped_db.service.mapper;


import RK_coffe_shop_mapped_db.db.entity.UserEntity;
import RK_coffe_shop_mapped_db.dto.CreateUserDto;
import org.springframework.stereotype.Component;

@Component
public class CreateUserMapper {
	public CreateUserMapper() {
	}
	
	public UserEntity toEntity(CreateUserDto dto) {
		return new UserEntity(
				dto.getUuid(),
				dto.getLogin(),
				dto.getPassword()
		);
	}
	
	public CreateUserDto fromEntity(UserEntity entity) {
		return new CreateUserDto(
				entity.getUUID(),
				entity.getLogin(),
				entity.getPassword()
		);
	}
}

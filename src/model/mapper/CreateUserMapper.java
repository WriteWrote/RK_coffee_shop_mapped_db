package model.mapper;

import db.entity.UserEntity;
import model.dto.CreateUserDto;

public class CreateUserMapper {
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

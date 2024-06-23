package model.mapper;

import db.entity.UserEntity;
import model.dto.CreateUserDto;
import model.dto.UserDto;

public class UserMapper {
	public UserEntity toEntity(UserDto dto) {
		return new UserEntity(
				dto.getUuid(),
				dto.getLogin()
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

package RK_coffe_shop_mapped_db.service.mapper;


import RK_coffe_shop_mapped_db.db.entity.UserEntity;
import RK_coffe_shop_mapped_db.dto.RequestUserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequestUserMapper {
	UserEntity toEntity(RequestUserDto dto);
	
	RequestUserDto toDto(UserEntity entity);
}

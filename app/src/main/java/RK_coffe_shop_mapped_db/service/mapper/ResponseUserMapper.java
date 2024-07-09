package RK_coffe_shop_mapped_db.service.mapper;


import RK_coffe_shop_mapped_db.db.entity.UserEntity;
import RK_coffe_shop_mapped_db.dto.ResponseUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ResponseUserMapper {
	@Mapping(target = "password", ignore = true)
	ResponseUserDto toDto(UserEntity entity);    //todo rename to toDto
}

package RK_coffe_shop_mapped_db.service.mapper;


import RK_coffe_shop_mapped_db.db.entity.UserEntity;
import RK_coffe_shop_mapped_db.dto.ResponseUserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponseUserMapper {
	ResponseUserDto toDto(UserEntity entity);
}

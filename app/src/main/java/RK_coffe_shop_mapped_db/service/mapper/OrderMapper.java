package RK_coffe_shop_mapped_db.service.mapper;


import RK_coffe_shop_mapped_db.db.entity.OrderEntity;
import RK_coffe_shop_mapped_db.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
	OrderEntity toEntity(OrderDto dto);
	
	@Mapping(target = "products", ignore = true)
	OrderDto toDto(OrderEntity entity);
}

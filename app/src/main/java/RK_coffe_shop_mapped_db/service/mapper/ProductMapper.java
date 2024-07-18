package RK_coffe_shop_mapped_db.service.mapper;


import RK_coffe_shop_mapped_db.db.entity.ProductEntity;
import RK_coffe_shop_mapped_db.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
	ProductEntity toEntity(ProductDto dto);
	
	ProductDto toDto(ProductEntity entity);
	
	ProductEntity merge(@MappingTarget ProductEntity target, ProductDto source);
}

package RK_coffe_shop_mapped_db.service.mapper;


import RK_coffe_shop_mapped_db.db.entity.ProductEntity;
import RK_coffe_shop_mapped_db.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	ProductEntity toEntity(ProductDto dto);
	
	ProductDto fromEntity(ProductEntity entity);
}

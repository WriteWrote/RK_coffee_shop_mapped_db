package RK_coffe_shop_mapped_db.service.mapper;


import RK_coffe_shop_mapped_db.db.entity.ProductEntity;
import RK_coffe_shop_mapped_db.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
	public ProductMapper() {
	}
	
	public ProductEntity toEntity(ProductDto dto) {
		return new ProductEntity(
				dto.getUuid(),
				dto.getName(),
				dto.getDescription()
		);
	}
	
	public ProductDto fromEntity(ProductEntity entity) {
		return new ProductDto(
				entity.getUUID(),
				entity.getName(),
				entity.getDescription()
		);
	}
}

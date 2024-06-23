package service.mapper;

import db.entity.ProductEntity;
import dto.ProductDto;

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

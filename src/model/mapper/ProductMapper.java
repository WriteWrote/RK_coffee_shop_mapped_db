package model.mapper;

import db.entity.ProductEntity;
import model.dto.ProductDto;

public class ProductMapper {
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

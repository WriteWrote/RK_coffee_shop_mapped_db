package service.mapper;

import db.entity.OrderEntity;
import dto.OrderDto;

public class OrderMapper {
	public OrderMapper() {
	}
	
	public OrderEntity toEntity(OrderDto dto) {
		return new OrderEntity(
				dto.getUuid(),
				dto.getCustomerID(),
				dto.getPhone(),
				dto.getFio(),
				dto.getAddress(),
				dto.getStatus()
		);
	}
	
	public OrderDto fromEntity(OrderEntity entity) {
		return new OrderDto(
				entity.getUUID(),
				entity.getCustomerId(),
				entity.getCustomerPhone(),
				entity.getCustomerFIO(),
				entity.getAddress(),
				entity.getStatus()
		);
	}
}

package RK_coffe_shop_mapped_db.service.mapper;


import RK_coffe_shop_mapped_db.db.entity.OrderLineEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrderLineMapper {
	default List<OrderLineEntity> toEntities(Map<UUID, Integer> dtos, UUID orderId) {
		return dtos.entrySet().stream().map(it -> new OrderLineEntity(
				null,
				orderId,
				it.getKey(),
				it.getValue()
			)
		).collect(Collectors.toList());
	}
	
	default Map<UUID, Integer> fromEntities(List<OrderLineEntity> entities) {
		return entities.stream().collect(Collectors.toMap(OrderLineEntity::getProductId, OrderLineEntity::getQuantity));
	}
}

package integration.testfactory;

import RK_coffe_shop_mapped_db.dto.OrderDto;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class OrderDtoProvider {
    private static final UUID orderId = UUID.fromString("00000000-0000-0000-0000-000000000001");
    private static final UUID customerId = UUID.fromString("00000000-0000-0000-0000-000000000001");
    private static final String phone = "88005553535";
    private static final String fio = "Ivanov Ivan Ivanovich";
    private static final String address = "Russia";
    private static final String status = "CREATED";
    private static final Map<UUID, Integer> products = Map.of(
            UUID.fromString("00000000-0000-0000-0000-000000000001"), 1
    );

    public OrderDto getValidOrderDto(Boolean leftIdNull, Boolean randomizeId, Boolean leftCustomerIdNull) {
        return new OrderDto(
                leftIdNull ? null : randomizeId ? UUID.randomUUID() : orderId,
                leftCustomerIdNull ? null : customerId,
                phone,
                fio,
                address,
                status,
                products
        );
    }
}

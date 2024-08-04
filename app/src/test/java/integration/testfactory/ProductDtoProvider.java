package integration.testfactory;

import RK_coffe_shop_mapped_db.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductDtoProvider {
    private static final UUID orderId = UUID.fromString("00000000-0000-0000-0000-000000000001");
    private static final String title = "Product";
    private static final String description = "Description";

    public ProductDto getValidUserDto(Boolean leftIdNull, Boolean randomizeId) {
        return new ProductDto(
                leftIdNull ? null : randomizeId ? UUID.randomUUID() : orderId,
                title,
                description
        );
    }
}

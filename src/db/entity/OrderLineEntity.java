package db.entity;

import java.util.UUID;

public class OrderLineEntity {
    private final UUID productId;
    private final UUID orderId;
    private final int quantity;

    public OrderLineEntity(UUID productId, UUID orderId, int quantity) {
        this.productId = productId;
        this.orderId = orderId;
        this.quantity = quantity;
    }

    public UUID getProductId() {
        return productId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public int getQuantity() {
        return quantity;
    }
}

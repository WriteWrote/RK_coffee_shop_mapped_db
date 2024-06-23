package db.entity;

import java.util.UUID;

public class OrderLineEntity extends Entity {
	private final UUID productId;
	private final UUID orderId;
	private final int quantity;
	
	public OrderLineEntity(UUID uuid, UUID orderId, UUID productId, int quantity) {
		super(uuid);
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

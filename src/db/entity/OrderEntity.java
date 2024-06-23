package db.entity;

import java.util.UUID;

public class OrderEntity extends Entity {
	private final UUID customerId;
	private final String customerPhone;
	private final String customerFIO;
	private final String address;
	private final String status;
	
	public OrderEntity(UUID uuid, UUID customerId, String customerPhone, String customerFIO, String address, String status) {
		super(uuid);
		this.customerId = customerId;
		this.customerPhone = customerPhone;
		this.customerFIO = customerFIO;
		this.address = address;
		this.status = status;
	}
	
	public UUID getCustomerId() {
		return customerId;
	}
	
	public String getCustomerPhone() {
		return customerPhone;
	}
	
	public String getCustomerFIO() {
		return customerFIO;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getStatus() {
		return status;
	}
}

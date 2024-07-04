package RK_coffe_shop_mapped_db.db.entity;

import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table(name = "", schema = "")
public class OrderEntity {
	private final UUID customerId;
	private final String customerPhone;
	private final String customerFIO;
	private final String address;
	private final String status;
	
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

package RK_coffe_shop_mapped_db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class OrderDto {
	private UUID uuid;
	private UUID customerID;
	private String phone;
	private String fio;
	private String address;
	private String status;
	
	private Map<UUID, Integer> products;
	
	public OrderDto(UUID uuid, UUID customerID, String phone, String fio, String address, String status) {
		this.uuid = uuid;
		this.customerID = customerID;
		this.phone = phone;
		this.fio = fio;
		this.address = address;
		this.status = status;
	}
	
	public void setProducts(Map<UUID, Integer> products) {
		this.products = products;
	}
}

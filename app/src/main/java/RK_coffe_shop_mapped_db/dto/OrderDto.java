package RK_coffe_shop_mapped_db.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class OrderDto {
	private UUID uuid;
	private UUID customerId;
	private String phone;
	private String fio;
	private String address;
	private String status;
	
	@Setter
	private Map<UUID, Integer> products;
	
	public OrderDto(UUID uuid, UUID customerId, String phone, String fio, String address, String status) {
		this.uuid = uuid;
		this.customerId = customerId;
		this.phone = phone;
		this.fio = fio;
		this.address = address;
		this.status = status;
	}
}

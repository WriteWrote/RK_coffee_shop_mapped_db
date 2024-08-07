package RK_coffe_shop_mapped_db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
	private UUID id;
	private UUID customerId;
	private String phone;
	private String fio;
	private String address;
	private String status;
	private Map<UUID, Integer> products;
}

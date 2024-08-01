package RK_coffe_shop_mapped_db.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@ToString
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

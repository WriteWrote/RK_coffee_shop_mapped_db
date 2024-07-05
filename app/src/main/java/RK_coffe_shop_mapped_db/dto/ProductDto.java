package RK_coffe_shop_mapped_db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class ProductDto {
	private UUID uuid;
	private String name;
	private String description;
	
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
}

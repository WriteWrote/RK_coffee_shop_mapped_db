package RK_coffe_shop_mapped_db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class ProductDto {
	private UUID id;
	private String title;
	private String description;
	
	public void setId(UUID id) {
		this.id = id;
	}
}

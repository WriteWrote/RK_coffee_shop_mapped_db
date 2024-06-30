package RK_coffe_shop_mapped_db.dto;

import java.util.UUID;

public class ProductDto {
	private final UUID uuid;
	private final String name;
	private final String description;
	
	public ProductDto(UUID uuid, String name, String description) {
		this.uuid = uuid;
		this.name = name;
		this.description = description;
	}
	
	public UUID getUuid() {
		return uuid;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
}

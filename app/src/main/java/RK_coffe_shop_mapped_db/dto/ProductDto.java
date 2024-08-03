package RK_coffe_shop_mapped_db.dto;

import lombok.*;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ProductDto {
	@Setter
	private UUID id;
	private String title;
	private String description;
}

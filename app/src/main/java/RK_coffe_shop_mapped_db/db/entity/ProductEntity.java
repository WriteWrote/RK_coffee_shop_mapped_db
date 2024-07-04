package RK_coffe_shop_mapped_db.db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Table(name = "products", schema = "rk_coffee_shop")
public class ProductEntity {
	@Id
	@Column("uuid")
	private final UUID uuid;
	@Column("title")
	private final String name;
	@Column("description")
	private final String description;
}

package RK_coffe_shop_mapped_db.db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Table(name = "products", schema = "rk_coffee_shop")
public class ProductEntity implements Persistable<UUID> {
	@Id
	@Column("uuid")
	private final UUID id;
	@Column("title")
	private final String name;
	@Column
	private final String description;
	
	@Override
	public UUID getId() {
		return id;
	}
	
	@Override
	public boolean isNew() {
		return id == null;
	}
}

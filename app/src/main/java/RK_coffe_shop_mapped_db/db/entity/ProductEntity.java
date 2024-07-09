package RK_coffe_shop_mapped_db.db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products", schema = "rk_coffee_shop")
public class ProductEntity implements Persistable<UUID> {
	@Id
	@Column("uuid")
	private UUID id;
	
	@Column("title")
	private String name;
	
	@Column
	private String description;
	
	@Override
	public UUID getId() {
		return id;
	}
	
	@Override
	public boolean isNew() {
		return id == null;
	}
}

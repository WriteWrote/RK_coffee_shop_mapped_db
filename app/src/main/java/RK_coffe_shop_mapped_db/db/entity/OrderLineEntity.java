package RK_coffe_shop_mapped_db.db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Table(name = "orders_lines")
public class OrderLineEntity {
	@Id
	@Column("uuid")
	private final UUID uuid;
	@Column("order_id")
	private final UUID orderId;
	@Column("product_id")
	private final UUID productId;
	@Column("quantity")
	private final int quantity;
}

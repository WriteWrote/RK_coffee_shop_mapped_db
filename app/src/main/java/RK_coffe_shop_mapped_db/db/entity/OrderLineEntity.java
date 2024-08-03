package RK_coffe_shop_mapped_db.db.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders_lines", schema = "rk_coffee_shop")
public class OrderLineEntity {
	@Id
	@Column("uuid")
	private UUID id;
	
	@Column("order_id")
	private UUID orderId;
	
	@Column("product_id")
	private UUID productId;
	
	@Column("quantity")
	private int quantity;
}

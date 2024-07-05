package RK_coffe_shop_mapped_db.db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Table(name = "order", schema = "rk_coffee_shop")
public class OrderEntity {
	@Id
	@Column("uuid")
	private final UUID uuid;
	@Column("customer_id")
	private final UUID customerId;
	@Column("customer_tel")
	private final String customerPhone;
	@Column("customer_fio")
	private final String customerFIO;
	@Column("address")
	private final String address;
	@Column("status")
	private final String status;
}

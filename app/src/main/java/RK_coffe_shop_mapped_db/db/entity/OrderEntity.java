package RK_coffe_shop_mapped_db.db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order", schema = "rk_coffee_shop")
public class OrderEntity {
	@Id
	@Column("uuid")
	private UUID id;
	
	@Column("customer_id")
	private UUID customerId;
	
	@Column("customer_tel")
	private String customerPhone;
	
	@Column("customer_fio")
	private String customerFIO;
	
	@Column("address")
	private String address;
	
	@Column("status")
	private String status;
}

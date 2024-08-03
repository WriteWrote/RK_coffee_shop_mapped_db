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
@Table(name = "users", schema = "rk_coffee_shop")
public class UserEntity {
	@Id
	@Column("uuid")
	private UUID id;
	
	@Column("login")
	private String login;
	
	@Column("password")
	private String password;
}

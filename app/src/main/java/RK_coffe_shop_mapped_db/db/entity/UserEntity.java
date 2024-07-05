package RK_coffe_shop_mapped_db.db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Table(name = "users", schema = "rk_coffee_shop")
public class UserEntity {
	@Id
	@Column("uuid")
	private UUID uuid;
	
	@Column("login")
	private String login;
	
	@Column("password")
	private String password;
	
	public UserEntity(UUID uuid, String login) {
		this.uuid = uuid;
		this.login = login;
	}
}

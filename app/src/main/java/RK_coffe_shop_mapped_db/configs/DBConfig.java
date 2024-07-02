package RK_coffe_shop_mapped_db.configs;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan("RK_coffe_shop_mapped_db/db/entity")
public class DBConfig {
}

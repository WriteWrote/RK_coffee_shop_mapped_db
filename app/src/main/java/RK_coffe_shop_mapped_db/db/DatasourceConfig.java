package RK_coffe_shop_mapped_db.db;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatasourceConfig {
	@Bean
	@Primary    // it is used because we can possibly have several datasources
	@ConfigurationProperties(prefix = "spring.datasource")
	public HikariDataSource hikariDataSource() {
		return DataSourceBuilder
			.create()
			.type(HikariDataSource.class)
			.build();
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(HikariDataSource hikariDataSource) {
		return new JdbcTemplate(hikariDataSource);
	}
}

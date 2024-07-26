package integration.common;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.support.TestPropertySourceUtils;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DockerPostgreDataSourceInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
	
	private final TestPostgreSQLContainer postgreSQLContainer = new TestPostgreSQLContainer("postgres:13.1")
		.withDatabaseName("CoffeShopDB")
		.withUsername("postgres")
		.withPassword("postgres")
		.withInitScript("db/init.sql");
	
	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		postgreSQLContainer.start();
		TestPropertySourceUtils.addInlinedPropertiesToEnvironment(
			applicationContext,
			"spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
			"spring.datasource.username=" + postgreSQLContainer.getUsername(),
			"spring.datasource.password=" + postgreSQLContainer.getPassword()
		);
	}
}

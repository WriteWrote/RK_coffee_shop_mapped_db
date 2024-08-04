package integration.common;

import RK_coffe_shop_mapped_db.App;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@AutoConfigureMockMvc
@ActiveProfiles("integration-test")
@SpringBootTest(classes = {App.class})
@ContextConfiguration(initializers = {DockerPostgreDataSourceInitializer.class})
public abstract class BaseTestClassConfig { }

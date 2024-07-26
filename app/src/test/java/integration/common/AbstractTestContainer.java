package integration.common;

import RK_coffe_shop_mapped_db.App;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(classes = {App.class})
@ActiveProfiles("integration-test")
@Testcontainers
@AutoConfigureMockMvc
@ContextConfiguration(initializers = {DockerPostgreDataSourceInitializer.class})
public abstract class AbstractTestContainer { }

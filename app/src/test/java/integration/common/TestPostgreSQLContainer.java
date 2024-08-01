package integration.common;

import org.testcontainers.containers.PostgreSQLContainer;

public class TestPostgreSQLContainer extends PostgreSQLContainer<TestPostgreSQLContainer> {
    public TestPostgreSQLContainer(String imageName) {
        super(imageName);
    }
}

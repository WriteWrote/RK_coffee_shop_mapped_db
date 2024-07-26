package integration.common;

import lombok.RequiredArgsConstructor;
import org.testcontainers.containers.PostgreSQLContainer;

@RequiredArgsConstructor
class TestPostgreSQLContainer extends PostgreSQLContainer<TestPostgreSQLContainer> {
	public final String imageName;
}

package integration;

import RK_coffe_shop_mapped_db.dto.OrderDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import integration.common.AbstractTestContainer;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql("/db/populate-db-test.sql")
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class OrderControllerTest extends AbstractTestContainer {
	private static final String BASE_URL = "/orders";
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void create() {
	}
	
	@Test
	public void delete() {
	}
	
	@Test
	public void update() {
	}
	
	@Test
	public void getById() {
	}
	
	@Test
	public void getAll() throws Exception {
		var result = mockMvc.perform(get(BASE_URL)).andExpect(status().isOk()).andReturn();
		var responseOrdersList = objectMapper.readValue(result.getResponse().getContentAsString(), OrderDto[].class);
		Assertions.assertNotEquals(0, responseOrdersList.length);
	}
}
package integration;

import RK_coffe_shop_mapped_db.dto.OrderDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import integration.common.BaseTestClassConfig;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql("/db/populate-db-test.sql")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class OrderControllerTest extends BaseTestClassConfig {

    private static final String BASE_URL = "/orders";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Order(1)
    public void create() throws Exception {
        var createdDto = new OrderDto(
                UUID.fromString("00000000-0000-0000-0000-000000000003"),
                UUID.fromString("00000000-0000-0000-0000-000000000001"),
                "88005553535",
                "Ivanov Ivan Ivanovich",
                "Russia",
                "CREATED",
                Map.of(UUID.fromString("00000000-0000-0000-0000-000000000001"), 1)
        );
        var response = mockMvc.perform(post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createdDto)))
                .andExpect(status().isCreated())
                .andReturn();
        var returnedDto = objectMapper.readValue(response.getResponse().getContentAsString(), OrderDto.class);
        assertEquals(createdDto, returnedDto);
    }

    @Test
    @Order(2)
    public void delete() throws Exception {
        var dtoForDeletion = new OrderDto(
                UUID.fromString("00000000-0000-0000-0000-000000000003"),
                UUID.fromString("00000000-0000-0000-0000-000000000001"),
                "88005553535",
                "Ivanov Ivan Ivanovich",
                "Russia",
                "CREATED",
                Map.of(UUID.fromString("00000000-0000-0000-0000-000000000001"), 1)
        );
        mockMvc.perform(post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dtoForDeletion)))
                .andExpect(status().isCreated())
                .andReturn();
        mockMvc.perform(MockMvcRequestBuilders.delete(BASE_URL + "/{id}", dtoForDeletion.getId()))
                .andExpect(status().isNoContent());
    }

    @Test
    @Order(3)
    public void update() throws Exception {
        var modifiedDto = new OrderDto(
                UUID.fromString("00000000-0000-0000-0000-000000000003"),
                UUID.fromString("00000000-0000-0000-0000-000000000001"),
                "88005553535",
                "Ivanov Ivan Ivanovich",
                "Russia",
                "CREATED",
                Map.of(UUID.fromString("00000000-0000-0000-0000-000000000001"), 1)
        );
        mockMvc.perform(post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(modifiedDto)))
                .andExpect(status().isCreated())
                .andReturn();
        modifiedDto.setPhone("01234567890");
        var response = mockMvc.perform(put(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(modifiedDto)))
                .andExpect(status().isOk())
                .andReturn();
        var returnedDto = objectMapper.readValue(response.getResponse().getContentAsString(), OrderDto.class);
        assertEquals(modifiedDto, returnedDto);
    }

    @Test
    @Order(4)
    public void getById() throws Exception {
        var expectedDto = new OrderDto(
                UUID.fromString("00000000-0000-0000-0000-000000000001"),
                UUID.fromString("00000000-0000-0000-0000-000000000001"),
                "88005553535",
                "Ivanov Ivan Ivanovich",
                "Russia",
                "CREATED",
                Map.of(UUID.fromString("00000000-0000-0000-0000-000000000001"), 1)
        );
        var response = mockMvc.perform(get(BASE_URL + "/{id}", expectedDto.getId())).andExpect(status().isOk()).andReturn();
        var returnedDto = objectMapper.readValue(response.getResponse().getContentAsString(), OrderDto.class);
        assertEquals(expectedDto, returnedDto);
    }

    @Test
    @Order(5)
    public void getAll() throws Exception {
        var response = mockMvc.perform(get(BASE_URL + "/all")).andExpect(status().isOk()).andReturn();
        var returnedDtoList = objectMapper.readValue(response.getResponse().getContentAsString(), OrderDto[].class);
        assertNotEquals(0, returnedDtoList.length);
    }
}
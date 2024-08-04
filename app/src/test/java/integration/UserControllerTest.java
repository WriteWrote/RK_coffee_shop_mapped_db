package integration;

import RK_coffe_shop_mapped_db.dto.OrderDto;
import RK_coffe_shop_mapped_db.dto.ResponseUserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import integration.common.BaseTestClassConfig;
import integration.testfactory.UserDtoProvider;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql("/db/populate-db-test.sql")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration(classes = {UserDtoProvider.class})
public class UserControllerTest extends BaseTestClassConfig {

    private static final String BASE_URL = "/users";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserDtoProvider userDtoProvider;

    @Test
    @Order(1)
    public void createUserIdNull_ReturnOk() throws Exception {
        var createdDto = userDtoProvider.getValidRequestUserDto(true, false);
        var response = mockMvc.perform(post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createdDto)))
                .andExpect(status().isCreated())
                .andReturn();
        var returnedDto = objectMapper.readValue(
                response.getResponse().getContentAsString(),
                ResponseUserDto.class
        );
        assertNotNull(returnedDto);
        assertNotNull(returnedDto.getId());
        assertEquals(createdDto.getLogin(), returnedDto.getLogin());
    }

    @Test
    @Order(2)
    public void deleteOrder_ReturnNoContent() throws Exception {
        var dtoForDeletion = userDtoProvider.getValidRequestUserDto(false, true);
        mockMvc.perform(post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dtoForDeletion)))
                .andExpect(status().isCreated());
        mockMvc.perform(MockMvcRequestBuilders.delete(BASE_URL + "/{id}", dtoForDeletion.getId()))
                .andExpect(status().isNoContent());
    }

    @Test
    @Order(3)
    public void updateOrder_ReturnUpdatedOrder() throws Exception {
        var modifiedDto = userDtoProvider.getValidRequestUserDto(false, true);
        mockMvc.perform(post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(modifiedDto)))
                .andExpect(status().isCreated());
        modifiedDto.setLogin("NewUserLogin");
        var response = mockMvc.perform(put(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(modifiedDto)))
                .andExpect(status().isOk())
                .andReturn();
        var returnedDto = objectMapper.readValue(
                response.getResponse().getContentAsString(),
                ResponseUserDto.class
        );
        assertNotNull(returnedDto);
        assertEquals(modifiedDto.getLogin(), returnedDto.getLogin());
    }

    @Test
    @Order(4)
    public void getById_ReturnOk() throws Exception {
        var expectedDto = userDtoProvider.getValidRequestUserDto(false, false);
        var response = mockMvc.perform(get(BASE_URL + "/{id}", expectedDto.getId()))
                .andExpect(status().isOk())
                .andReturn();
        var returnedDto = objectMapper.readValue(
                response.getResponse().getContentAsString(),
                ResponseUserDto.class
        );
        assertNotNull(returnedDto);
        assertEquals(expectedDto.getLogin(), returnedDto.getLogin());
    }

    @Test
    @Order(5)
    public void getAll_ReturnOk() throws Exception {
        var response = mockMvc.perform(get(BASE_URL + "/all"))
                .andExpect(status().isOk())
                .andReturn();
        var returnedDtoList = objectMapper.readValue(
                response.getResponse().getContentAsString(),
                ResponseUserDto[].class
        );
        assertNotNull(returnedDtoList);
        assertNotEquals(0, returnedDtoList.length);
    }
}
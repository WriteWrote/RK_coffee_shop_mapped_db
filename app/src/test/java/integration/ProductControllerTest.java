package integration;

import RK_coffe_shop_mapped_db.dto.OrderDto;
import RK_coffe_shop_mapped_db.dto.ProductDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import integration.common.BaseTestClassConfig;
import integration.testfactory.ProductDtoProvider;
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
@ContextConfiguration(classes = {ProductDtoProvider.class})
public class ProductControllerTest extends BaseTestClassConfig {

    private static final String BASE_URL = "/products";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProductDtoProvider productDtoProvider;

    @Test
    @Order(1)
    public void createOrderIdNull_ReturnOk() throws Exception {
        var createdDto = productDtoProvider.getValidUserDto(true, false);
        var response = mockMvc.perform(post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createdDto)))
                .andExpect(status().isCreated())
                .andReturn();
        var returnedDto = objectMapper.readValue(
                response.getResponse().getContentAsString(),
                ProductDto.class
        );
        assertNotNull(returnedDto);
        assertNotNull(returnedDto.getId());
        assertDtoFieldEqualsExceptId(createdDto, returnedDto);
    }

    @Test
    @Order(2)
    public void deleteOrder_ReturnNoContent() throws Exception {
        var dtoForDeletion = productDtoProvider.getValidUserDto(false, true);
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
        var modifiedDto = productDtoProvider.getValidUserDto(false, true);
        mockMvc.perform(post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(modifiedDto)))
                .andExpect(status().isCreated());
        modifiedDto.setDescription("New Description");
        var response = mockMvc.perform(put(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(modifiedDto)))
                .andExpect(status().isOk())
                .andReturn();
        var returnedDto = objectMapper.readValue(
                response.getResponse().getContentAsString(),
                ProductDto.class
        );
        assertNotNull(returnedDto);
        assertDtoFieldEqualsExceptId(modifiedDto, returnedDto);
    }

    @Test
    @Order(4)
    public void getById_ReturnOk() throws Exception {
        var expectedDto = productDtoProvider.getValidUserDto(false, false);
        var response = mockMvc.perform(get(BASE_URL + "/{id}", expectedDto.getId()))
                .andExpect(status().isOk())
                .andReturn();
        var returnedDto = objectMapper.readValue(
                response.getResponse().getContentAsString(),
                ProductDto.class
        );
        assertNotNull(returnedDto);
        assertDtoFieldEqualsExceptId(expectedDto, returnedDto);
    }

    @Test
    @Order(5)
    public void getAll_ReturnOk() throws Exception {
        var response = mockMvc.perform(get(BASE_URL + "/all"))
                .andExpect(status().isOk())
                .andReturn();
        var returnedDtoList = objectMapper.readValue(
                response.getResponse().getContentAsString(),
                OrderDto[].class
        );
        assertNotNull(returnedDtoList);
        assertNotEquals(0, returnedDtoList.length);
    }

    private void assertDtoFieldEqualsExceptId(ProductDto expectedDto, ProductDto actualDto) {
        assertEquals(expectedDto.getTitle(), actualDto.getTitle());
        assertEquals(expectedDto.getDescription(), actualDto.getDescription());
    }
}
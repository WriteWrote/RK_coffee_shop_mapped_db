package integration.testfactory;

import RK_coffe_shop_mapped_db.dto.RequestUserDto;
import RK_coffe_shop_mapped_db.dto.ResponseUserDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserDtoProvider {
    private static final UUID userId = UUID.fromString("00000000-0000-0000-0000-000000000001");
    private static final String login = "userlogin";
    private static final String password = "Pa$$w0rd!";

    public RequestUserDto getValidRequestUserDto(Boolean leftIdNull, Boolean randomizeId) {
        return new RequestUserDto(
                leftIdNull ? null : randomizeId ? UUID.randomUUID() : userId,
                login,
                password
        );
    }

    public ResponseUserDto getValidResponseUserDto(Boolean leftIdNull, Boolean randomizeId) {
        return new ResponseUserDto(
                leftIdNull ? null : randomizeId ? UUID.randomUUID() : userId,
                login
        );
    }
}
